package christmas.domain.dto;

import christmas.domain.food.Drink;
import christmas.domain.food.Food;

public enum BenefitFood {
    BENEFIT_FOOD(Drink.CHAMPAGNE, 1),
    NO_BENEFIT_FOOD(null, 0);

    private final Food benefitFood;
    private final int count;

    BenefitFood(Food benefitFood, int count) {
        this.benefitFood = benefitFood;
        this.count = count;
    }

    public Food getBenefitFood() {
        return benefitFood;
    }

    public int getCount() {
        return count;
    }
}
