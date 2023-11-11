package christmas.domain.dto;

import christmas.domain.food.Food;

public record BenefitFoodDto(Food food, int count) {
    public static BenefitFoodDto create(Food benefitFood) {
        return new BenefitFoodDto(benefitFood, 1);
    }

    public static BenefitFoodDto createNoBenefitFood() {
        return new BenefitFoodDto(null, 0);
    }
}
