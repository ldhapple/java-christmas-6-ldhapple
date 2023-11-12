package christmas.domain.event;

import static christmas.domain.event.EventConstants.*;

import christmas.domain.food.Drink;
import christmas.domain.food.Food;
import java.util.Arrays;
import java.util.function.Predicate;

public enum BenefitFood {
    BENEFIT_FOOD(Drink.CHAMPAGNE, BENEFIT_MENU_COUNT.getValue(),
            (totalOrderAmount) -> totalOrderAmount >= BENEFIT_MENU_MIN_PAY_AMOUNT.getValue()),
    NO_BENEFIT_FOOD(Drink.CHAMPAGNE, 0, (totalOrderAmount) -> totalOrderAmount < BENEFIT_MENU_MIN_PAY_AMOUNT.getValue());

    private final Food food;
    private final int count;
    private final Predicate<Integer> benefitFoodCondition;

    BenefitFood(Food food, int count, Predicate<Integer> benefitFoodCondition) {
        this.food = food;
        this.count = count;
        this.benefitFoodCondition = benefitFoodCondition;
    }

    public static BenefitFood createBenefitFood(int orderTotalAmount) {
        return Arrays.stream(BenefitFood.values())
                .filter((benefitFood) -> benefitFood.benefitFoodCondition.test(orderTotalAmount))
                .findAny()
                .orElse(NO_BENEFIT_FOOD);
    }

    public boolean hasBenefitFood() {
        return this != NO_BENEFIT_FOOD;
    }

    public Food getFood() {
        return food;
    }

    public int getCount() {
        return count;
    }
}
