package christmas.domain;

import christmas.domain.food.Food;
import christmas.domain.food.MainFood;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Menu Enum 클래스 테스트")
class MenuTest {

    @Test
    @DisplayName("메뉴에 있는 음식 이름을 입력하면 true 반환")
    void isFoodInMenuTest() {
        String foodName = "아이스크림";

        boolean foodInMenu = Menu.isFoodInMenu(foodName);

        Assertions.assertThat(foodInMenu).isEqualTo(true);
    }

    @Test
    @DisplayName("메뉴에 없는 음식 이름을 입력하면 false 반환")
    void isNotFoodInMenuTest() {
        String foodName = "핫도그";

        boolean foodIsNotInMenu = Menu.isFoodInMenu(foodName);

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
}