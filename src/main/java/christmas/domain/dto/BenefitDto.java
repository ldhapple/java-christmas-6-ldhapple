package christmas.domain.dto;

import christmas.domain.event.Badge;
import christmas.domain.event.DiscountPolicy;
import christmas.domain.food.Food;
import java.util.EnumMap;

public record BenefitDto(EnumMap<DiscountPolicy, Integer> discountResults, BenefitFoodDto benefitFood) {
    public static BenefitDto create(EnumMap<DiscountPolicy, Integer> discountResults, BenefitFoodDto benefitFood) {
        return new BenefitDto(discountResults, benefitFood);
    }
}
