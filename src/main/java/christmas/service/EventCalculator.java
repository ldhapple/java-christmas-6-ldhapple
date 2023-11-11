package christmas.service;

import christmas.domain.Orders;
import christmas.domain.VisitDate;
import christmas.domain.dto.BenefitFoodDto;
import christmas.domain.event.DiscountPolicy;
import christmas.domain.food.Food;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class EventCalculator {

    public int getOrderTotalAmount(Orders orders) {
        int orderTotalPrice = 0;

        Map<Food, Integer> order = orders.getOrders();

        for (Entry<Food, Integer> entry : order.entrySet())
        {
            Food orderFood = entry.getKey();
            int orderFoodPrice = orderFood.getPrice();
            int orderFoodCount = entry.getValue();

            orderTotalPrice += orderFoodPrice * orderFoodCount;
        }

        return orderTotalPrice;
    }

    public EnumMap<DiscountPolicy, Integer> getDiscountResult (List<DiscountPolicy> discountPolicies, VisitDate visitDate, Orders orders) {
        EnumMap<DiscountPolicy, Integer> results = new EnumMap<>(DiscountPolicy.class);

        for (DiscountPolicy discountPolicy : discountPolicies) {
            int requiredValue = getRequiredValue(visitDate, orders, discountPolicy);
            int discountAmount = discountPolicy.getDiscountAmount(requiredValue);

            results.put(discountPolicy, discountAmount);
        }

        return results;
    }

    public int getTotalBenefitAmount(EnumMap<DiscountPolicy, Integer> discountResults, BenefitFoodDto benefitFood) {
        int totalDiscountAmount = 0;
        for (int discountAmount : discountResults.values()) {
            totalDiscountAmount += discountAmount;
        }

        if (benefitFood.count() != 0) {
            Food bonusFood = benefitFood.food();
            totalDiscountAmount += bonusFood.getPrice() * -1;
        }

        return totalDiscountAmount;
    }

    public int getExpectedPayAmount(int orderTotalAmount, int benefitAmount) {
        return orderTotalAmount + benefitAmount;
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
