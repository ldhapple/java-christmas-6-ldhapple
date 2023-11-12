package christmas.domain.restaurant;

import christmas.domain.food.Food;
import christmas.domain.food.MainFood;
import christmas.domain.restaurant.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuTest {

    @ParameterizedTest
    @ValueSource(strings = {"아이스크림", "티본스테이크", "타파스", "제로콜라"})
    @DisplayName("메뉴에 있는 음식 이름을 입력하면 true 반환")
    void isFoodInMenuTest(String foodNames) {
        boolean foodInMenu = Menu.isFoodInMenu(foodNames);

        Assertions.assertThat(foodInMenu).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"핫도그", "파스타", "스테이크", "초코우유"})
    @DisplayName("메뉴에 없는 음식 이름을 입력하면 false 반환")
    void isNotFoodInMenuTest(String foodNames) {
        boolean foodIsNotInMenu = Menu.isFoodInMenu(foodNames);

        Assertions.assertThat(foodIsNotInMenu).isEqualTo(false);
    }

    @Test
    @DisplayName("음식 이름을 입력했을 때 해당 음식을 정상적으로 반환")
    void getFoodByNameTest() {
        String foodName = "크리스마스파스타";

        Food food = Menu.getFoodByName(foodName);

        Assertions.assertThat(food).isEqualTo(MainFood.CHRISTMAS_PASTA);
    }

    @Test
    @DisplayName("DRINK_MENU 에 해당하는 음식이라면 isDrink = ture")
    void isDrinkTest() {
        String foodName = "샴페인";

        boolean checkDrink = Menu.isDrink(foodName);

        Assertions.assertThat(checkDrink).isEqualTo(true);
    }

    @Test
    @DisplayName("DRINK_MENU 에 해당하지 않는 음식이라면 isDrink = false")
    void isNotDrinkTest() {
        String foodName = "티본스테이크";

        boolean checkDrink = Menu.isDrink(foodName);

        Assertions.assertThat(checkDrink).isEqualTo(false);
    }
}