package christmas.domain.event;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.food.Drink;
import christmas.domain.food.Food;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitFoodTest {

    @Test
    @DisplayName("구매 금액이 120,000원 이상이면 증정 메뉴를 제공한다.")
    void getBenefitFoodTest() {
        int orderAmount = 120_000;

        BenefitFood benefitFood = BenefitFood.createBenefitFood(orderAmount);

        Assertions.assertEquals(BenefitFood.BENEFIT_FOOD, benefitFood);
    }

    @Test
    @DisplayName("구매 금액이 120,000원 미만이면 증정 메뉴를 제공하지 않는다.")
    void noBenefitFoodTest() {
        int orderAmount = 119_000;

        BenefitFood benefitFood = BenefitFood.createBenefitFood(orderAmount);

        Assertions.assertEquals(BenefitFood.NO_BENEFIT_FOOD, benefitFood);
    }

    @Test
    @DisplayName("증정 메뉴는 샴페인이다.")
    void benefitFoodTypeTest() {
        BenefitFood benefitFood = BenefitFood.BENEFIT_FOOD;

        Food food = benefitFood.getFood();

        Assertions.assertEquals(Drink.CHAMPAGNE, food);
    }

    @Test
    @DisplayName("증정 메뉴의 개수는 1개이다.")
    void benefitFoodCountTest() {
        BenefitFood benefitFood = BenefitFood.BENEFIT_FOOD;

        int count = benefitFood.getCount();

        Assertions.assertEquals(1, count);
    }
}