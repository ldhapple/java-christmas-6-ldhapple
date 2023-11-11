package christmas.domain;

import christmas.domain.food.Drink;
import christmas.domain.food.Food;
import java.util.Arrays;
import java.util.function.Predicate;

public enum BenefitFood {
    BENEFIT_FOOD(Drink.CHAMPAGNE, 1, (totalOrderAmount) -> totalOrderAmount >= 120_000),
    NO_BENEFIT_FOOD(null, 0, (totalOrderAmount) -> totalOrderAmount < 120_000);

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
