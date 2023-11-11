package christmas.domain.dto;

import static christmas.domain.dto.BenefitFood.*;

import christmas.domain.food.Food;

public record BenefitFoodDto(Food food, int count) {
    public static BenefitFoodDto create() {
        return new BenefitFoodDto(BENEFIT_FOOD.getBenefitFood(), BENEFIT_FOOD.getCount());
    }

    public static BenefitFoodDto createNoBenefitFood() {
        return new BenefitFoodDto(NO_BENEFIT_FOOD.getBenefitFood(), NO_BENEFIT_FOOD.getCount());
    }
}
