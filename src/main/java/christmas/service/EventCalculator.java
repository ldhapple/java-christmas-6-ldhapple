package christmas.service;

import christmas.domain.event.BenefitFood;
import christmas.domain.restaurant.Orders;
import christmas.domain.restaurant.VisitDate;
import christmas.domain.event.DiscountPolicy;
import christmas.domain.food.Food;
import java.util.EnumMap;
import java.util.List;

public class EventCalculator {

    public EnumMap<DiscountPolicy, Integer> getDiscountResult (List<DiscountPolicy> discountPolicies, VisitDate visitDate, Orders orders) {
        EnumMap<DiscountPolicy, Integer> results = new EnumMap<>(DiscountPolicy.class);

        for (DiscountPolicy discountPolicy : discountPolicies) {
            int requiredValue = getRequiredValue(visitDate, orders, discountPolicy);
            int discountAmount = discountPolicy.getDiscountAmount(requiredValue);

            results.put(discountPolicy, discountAmount);
        }

        return results;
    }

    public int getTotalBenefitAmount(EnumMap<DiscountPolicy, Integer> discountResults, BenefitFood benefitFood) {
        int totalDiscountAmount = 0;
        for (int discountAmount : discountResults.values()) {
            totalDiscountAmount += discountAmount;
        }

        if (benefitFood.hasBenefitFood()) {
            Food bonusFood = benefitFood.getFood();
            totalDiscountAmount += bonusFood.getPrice() * -1;
        }

        return totalDiscountAmount;
    }

    public int getExpectedPayAmount(int orderTotalAmount, int benefitAmount) {
        return orderTotalAmount + benefitAmount;
    }

    public int getLastBenefitAmount(int totalBenefitAmount, BenefitFood benefitFood) {
        int lastBenefitAmount = totalBenefitAmount;

        if (benefitFood.hasBenefitFood()) {
            Food bonusFood = benefitFood.getFood();
            lastBenefitAmount += bonusFood.getPrice();
        }

        return lastBenefitAmount;
    }

    private int getRequiredValue(VisitDate visitDate, Orders orders, DiscountPolicy discountPolicy) {
        if (isChristmasDiscount(discountPolicy)) {
            return visitDate.getDate();
        }

        if (isWeekDayDiscount(discountPolicy)) {
            return orders.getDessertMenuCount();
        }

        if (isWeekEndDiscount(discountPolicy)) {
            return orders.getMainMenuCount();
        }

        return 0;
    }

    private boolean isWeekEndDiscount(DiscountPolicy discountPolicy) {
        return discountPolicy.equals(DiscountPolicy.WEEKEND_DISCOUNT);
    }

    private boolean isWeekDayDiscount(DiscountPolicy discountPolicy) {
        return discountPolicy.equals(DiscountPolicy.WEEK_DAY_DISCOUNT);
    }

    private boolean isChristmasDiscount(DiscountPolicy discountPolicy) {
        return discountPolicy.equals(DiscountPolicy.CHRISTMAS_DISCOUNT);
    }
}
