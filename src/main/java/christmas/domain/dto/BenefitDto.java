package christmas.domain.dto;

import christmas.domain.event.DiscountPolicy;
import christmas.domain.BenefitFood;
import java.util.EnumMap;

public record BenefitDto(EnumMap<DiscountPolicy, Integer> discountResults, BenefitFood benefitFood) {
    public static BenefitDto create(EnumMap<DiscountPolicy, Integer> discountResults, BenefitFood benefitFood) {
        return new BenefitDto(discountResults, benefitFood);
    }
}
