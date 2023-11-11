package christmas.controller;

import christmas.domain.BenefitFood;
import christmas.domain.Orders;
import christmas.domain.VisitDate;
import christmas.domain.dto.BenefitDto;
import christmas.domain.event.Badge;
import christmas.domain.event.DiscountPolicy;
import christmas.domain.food.Food;
import christmas.service.EventCalculator;
import christmas.view.outputview.OutputView;
import java.util.EnumMap;
import java.util.List;

public class EventPlanerController {

    private final EventCalculator eventCalculator;

    public EventPlanerController(EventCalculator eventCalculator) {
        this.eventCalculator = eventCalculator;
    }

    public void executeEventPlaner(VisitDate visitDate, Orders orders) {
        OutputView.printEventPreviewMessage(visitDate);
        int orderTotalAmount = eventCalculator.getOrderTotalAmount(orders);
        OutputView.printOrder(orders, orderTotalAmount);

        List<DiscountPolicy> discountPolicies = DiscountPolicy.findDiscountPolicies(visitDate);

        EnumMap<DiscountPolicy, Integer> discountResults = eventCalculator.getDiscountResult(discountPolicies,
                visitDate, orders);

        BenefitFood benefitFood = BenefitFood.createBenefitFood(orderTotalAmount);
        BenefitDto benefits = BenefitDto.create(discountResults, benefitFood);
        int totalBenefitAmount = eventCalculator.getTotalBenefitAmount(discountResults, benefitFood);

        int lastBenefitAmount = totalBenefitAmount;
        if (benefitFood.hasBenefitFood()) {
            Food bonusFood = benefitFood.getFood();
            lastBenefitAmount += bonusFood.getPrice();
        } //eventCalc

        int expectedPayAmount = eventCalculator.getExpectedPayAmount(orderTotalAmount, lastBenefitAmount);
        Badge benefitBadge = Badge.findBadge(totalBenefitAmount);

        OutputView.printEventDetails(benefits, totalBenefitAmount, expectedPayAmount);
        OutputView.printEventBadge(benefitBadge);
    }
}
