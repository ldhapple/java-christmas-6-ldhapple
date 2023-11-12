package christmas.domain.restaurant;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.restaurant.Orders;
import christmas.exception.menu.DuplicateMenuException;
import christmas.exception.order.InvalidOrderFormatException;
import christmas.exception.menucount.MenuCountLessThanOneException;
import christmas.exception.menu.MenuNotExistException;
import christmas.exception.menucount.MenuTotalCountExceedMaxException;
import christmas.exception.order.OnlyDrinkOrderException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrdersTest {

    @ParameterizedTest
    @ValueSource(strings = "아이스크림-1,크리스마스파스타-2,샴페인-2")
    @DisplayName("정상 포맷으로 입력 시 예외를 발생시키지 않는다.")
    void validOrdersTest(String orders) {
        assertDoesNotThrow(() -> Orders.create(orders));
    }

    @ParameterizedTest
    @ValueSource(strings = {"iceCream-1,coke-2", "아이스크림-1, 타파스-1", "아이스크림=2,타파스=3", "아이스크림-3,타파스-세개"})
    @DisplayName("메뉴가 한글이 아니거나, 공백이 입력, 구분자가 다르거나, 메뉴 개수가 숫자가 아니라면 예외 발생")
    void invalidFormatOrdersTest(String invalidOrders) {
        assertThrows(InvalidOrderFormatException.class, () -> {
            Orders.create(invalidOrders);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"스테이크-3", "시저샐러드-3,코카콜라-3"})
    @DisplayName("메뉴에 없는 메뉴를 주문하면 예외 발생")
    void foodNotContainMenuOrdersTest(String notContainFoodOrders) {
        assertThrows(MenuNotExistException.class, () -> {
            Orders.create(notContainFoodOrders);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"시저샐러드-3,시저샐러드-2", "바비큐립-2,바비큐립-1,크리스마스파스타-3"})
    @DisplayName("중복되는 메뉴를 주문하면 예외 발생")
    void duplicateMenuOrdersTest(String duplicateFoodOrders) {
        assertThrows(DuplicateMenuException.class, () -> {
            Orders.create(duplicateFoodOrders);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"샴페인-1,제로콜라-3", "레드와인-1,샴페인-1"})
    @DisplayName("음료만 주문하면 예외가 발생한다.")
    void onlyDrinkOrdersTest(String onlyDrinkOrders) {
        assertThrows(OnlyDrinkOrderException.class, () -> {
            Orders.create(onlyDrinkOrders);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"타파스-20","크리스마스파스타-3,제로콜라-3"})
    @DisplayName("주문 수량이 정상 범위 내에 있으면 예외를 발생시키지 않는다.")
    void validOrdersCountTest(String validCountOrders) {
        assertDoesNotThrow(() -> Orders.create(validCountOrders));
    }

    @ParameterizedTest
    @ValueSource(strings = {"크리스마스파스타-0"})
    @DisplayName("주문 수량이 0이면 예외 발생")
    void invalidRangeCountOrdersTest(String invalidRangeCountOrders) {
        assertThrows(MenuCountLessThanOneException.class, () -> {
            Orders.create(invalidRangeCountOrders);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"크리스마스파스타-7,제로콜라-7,레드와인-7", "아이스크림-19,타파스-2", "타파스-21"})
    @DisplayName("주문 수량의 총 합이 20이 넘으면 예외 발생")
    void totalCountsExceedMaxTest(String exceedCountOrders) {
        assertThrows(MenuTotalCountExceedMaxException.class, () -> {
            Orders.create(exceedCountOrders);
        });
    }

    @Test
    @DisplayName("메인 메뉴의 개수 정상 반환 테스트")
    void getMainMenuCountTest() {
        Orders order = Orders.create("크리스마스파스타-7,제로콜라-7,아이스크림-3");
        int mainMenuCount = order.getMainMenuCount();

        assertEquals(7, mainMenuCount);
    }

    @Test
    @DisplayName("디저트 메뉴의 개수 정상 반환 테스트")
    void getDessertMenuCountTest() {
        Orders order = Orders.create("크리스마스파스타-7,제로콜라-7,아이스크림-3");
        int dessertMenuCount = order.getDessertMenuCount();

        assertEquals(3, dessertMenuCount);
    }
}