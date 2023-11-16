package christmas.service;

import christmas.domain.event.BenefitFood;
import christmas.domain.event.DiscountRequiredValueMapper;
import christmas.domain.restaurant.Orders;
import christmas.domain.restaurant.VisitDate;
import christmas.domain.event.DiscountPolicy;
import christmas.domain.food.Food;
import java.util.EnumMap;
import java.util.List;

public class EventCalculator {

    public EnumMap<DiscountPolicy, Integer> getDiscountResult(List<DiscountPolicy> discountPolicies,
                                                              VisitDate visitDate, Orders orders) {
        EnumMap<DiscountPolicy, Integer> results = new EnumMap<>(DiscountPolicy.class);
        DiscountRequiredValueMapper discountRequiredValues = DiscountRequiredValueMapper.create(visitDate, orders);

        for (DiscountPolicy discountPolicy : discountPolicies) {
            int discountAmount = getDiscountAmount(discountRequiredValues, discountPolicy);

            results.put(discountPolicy, discountAmount);
        }

        return results;
    }

    public int getTotalBenefitAmount(EnumMap<DiscountPolicy, Integer> discountResults, BenefitFood benefitFood) {
        int totalDiscountAmount = 0;

        for (int discountAmount : discountResults.values()) {
            totalDiscountAmount += discountAmount;
        }

        totalDiscountAmount = calculateIfExistBenefitFood(benefitFood, totalDiscountAmount);

        return totalDiscountAmount;
    }

    public int getFinalBenefitAmount(int totalBenefitAmount, BenefitFood benefitFood) {
        int finalBenefitAmount = totalBenefitAmount;

        if (existBenefitFood(benefitFood)) {
            Food bonusFood = benefitFood.getFood();
            finalBenefitAmount += bonusFood.getPrice();
        }

        return finalBenefitAmount;
    }

    public int getExpectedPayAmount(int orderTotalAmount, int finalBenefitAmount) {
        return orderTotalAmount + finalBenefitAmount;
    }

    private static int getDiscountAmount(DiscountRequiredValueMapper discountRequiredValues, DiscountPolicy discountPolicy) {
        int requiredValue = discountRequiredValues.getRequiredValue(discountPolicy);
        return discountPolicy.getDiscountAmount(requiredValue);
    }

    private static int calculateIfExistBenefitFood(BenefitFood benefitFood, int totalDiscountAmount) {
        if (existBenefitFood(benefitFood)) {
            Food bonusFood = benefitFood.getFood();
            totalDiscountAmount += bonusFood.getPrice() * -1;
        }
        return totalDiscountAmount;
    }

    private static boolean existBenefitFood(BenefitFood benefitFood) {
        return benefitFood.hasBenefitFood();
    }
}
