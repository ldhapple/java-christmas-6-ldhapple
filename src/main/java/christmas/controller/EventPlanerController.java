package christmas.controller;

import christmas.domain.Orders;
import christmas.domain.VisitDate;
import christmas.domain.dto.BenefitDto;
import christmas.domain.dto.BenefitFoodDto;
import christmas.domain.event.Badge;
import christmas.domain.event.DiscountPolicy;
import christmas.domain.food.Drink;
import christmas.domain.food.Food;
import christmas.service.EventCalculator;
import christmas.view.inputview.InputValueType;
import christmas.view.inputview.InputView;
import christmas.view.outputview.OutputView;
import java.util.EnumMap;
import java.util.List;

public class EventPlanerController {

    private final EventCalculator eventCalculator;

    public EventPlanerController(EventCalculator eventCalculator) {
        this.eventCalculator = eventCalculator;
    }

    public void executeEventPlaner(VisitDate visitDate, Orders orders) {
        OutputView.printEventMessage(visitDate);
        int orderTotalAmount = eventCalculator.getOrderTotalAmount(orders);
        OutputView.printOrder(orders, orderTotalAmount);

        List<DiscountPolicy> discountPolicies = DiscountPolicy.findDiscountPolicies(visitDate);

        EnumMap<DiscountPolicy, Integer> discountResults = eventCalculator.getDiscountResult(discountPolicies,
                visitDate, orders);

        BenefitFoodDto benefitFood = getBenefitFood(orderTotalAmount);
        BenefitDto benefits = BenefitDto.create(discountResults, benefitFood);
        OutputView.printBenefits(benefits);

        int totalBenefitAmount = eventCalculator.getTotalBenefitAmount(discountResults, benefitFood);

        int lastBenefitAmount = totalBenefitAmount;
        if (benefitFood.hasBenefitFood()) {
            Food bonusFood = benefitFood.food();
            lastBenefitAmount += bonusFood.getPrice();
        }

        int expectedPayAmount = eventCalculator.getExpectedPayAmount(orderTotalAmount, lastBenefitAmount);
        Badge benefitBadge = Badge.findBadge(totalBenefitAmount);

        OutputView.printResultAmount(totalBenefitAmount, expectedPayAmount);
        OutputView.printBadge(benefitBadge);
    }

    private BenefitFoodDto getBenefitFood(int orderTotalAmount) {
        if (orderTotalAmount >= 120_000) {
            return BenefitFoodDto.create();
        }

        return BenefitFoodDto.createNoBenefitFood();
    }
}
