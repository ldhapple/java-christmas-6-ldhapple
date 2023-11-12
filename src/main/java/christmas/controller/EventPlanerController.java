package christmas.controller;

import christmas.domain.event.BenefitFood;
import christmas.domain.restaurant.Orders;
import christmas.domain.restaurant.VisitDate;
import christmas.dto.BenefitDto;
import christmas.domain.event.Badge;
import christmas.domain.event.DiscountPolicy;
import christmas.service.EventCalculator;
import christmas.view.outputview.OutputView;
import java.util.EnumMap;
import java.util.List;

public class EventPlanerController {
    private final EventCalculator eventCalculator;

    public EventPlanerController(EventCalculator eventCalculator) {
        this.eventCalculator = eventCalculator;
    }

    public void executeEventPlaner(VisitDate visitDate, Orders orders, int orderTotalAmount) {
        EnumMap<DiscountPolicy, Integer> discountResults = getDiscountResult(visitDate, orders);
        BenefitFood benefitFood = checkBenefitFood(orderTotalAmount);
        BenefitDto benefits = getBenefits(discountResults, benefitFood);

        int totalBenefitAmount = getTotalBenefitAmount(discountResults, benefitFood);
        int finalBenefitAmount = getFinalBenefitAmount(benefitFood, totalBenefitAmount);
        int expectedPayAmount = getExpectedPayAmount(orderTotalAmount, finalBenefitAmount);

        Badge benefitBadge = checkBenefitBadge(totalBenefitAmount);

        showEventResult(benefits, totalBenefitAmount, expectedPayAmount, benefitBadge);
    }

    public void notApplyEvent(int orderTotalAmount) {
        EnumMap<DiscountPolicy, Integer> discountResults = new EnumMap<>(DiscountPolicy.class);
        BenefitDto benefits = getBenefits(discountResults, BenefitFood.NO_BENEFIT_FOOD);

        showNothingEventResult(benefits, orderTotalAmount);
    }

    private EnumMap<DiscountPolicy, Integer> getDiscountResult(VisitDate visitDate, Orders orders) {
        List<DiscountPolicy> discountPolicies = DiscountPolicy.findDiscountPolicies(visitDate);

        return eventCalculator.getDiscountResult(discountPolicies, visitDate, orders);
    }

    private static void showEventResult(BenefitDto benefits, int totalBenefitAmount, int expectedPayAmount,
                                        Badge benefitBadge) {
        OutputView.printEventDetails(benefits, totalBenefitAmount, expectedPayAmount);
        OutputView.printEventBadge(benefitBadge);
    }

    private void showNothingEventResult(BenefitDto benefits, int orderTotalAmount) {
        int expectedPayAmount = getExpectedPayAmount(orderTotalAmount, 0);
        showEventResult(benefits, 0, expectedPayAmount, Badge.NO_BADGE);
    }

    private static BenefitFood checkBenefitFood(int orderTotalAmount) {
        return BenefitFood.createBenefitFood(orderTotalAmount);
    }

    private static BenefitDto getBenefits(EnumMap<DiscountPolicy, Integer> discountResults, BenefitFood benefitFood) {
        return BenefitDto.create(discountResults, benefitFood);
    }

    private int getTotalBenefitAmount(EnumMap<DiscountPolicy, Integer> discountResults, BenefitFood benefitFood) {
        return eventCalculator.getTotalBenefitAmount(discountResults, benefitFood);
    }

    private int getFinalBenefitAmount(BenefitFood benefitFood, int totalBenefitAmount) {
        return eventCalculator.getLastBenefitAmount(totalBenefitAmount, benefitFood);
    }

    private int getExpectedPayAmount(int orderTotalAmount, int finalBenefitAmount) {
        return eventCalculator.getExpectedPayAmount(orderTotalAmount, finalBenefitAmount);
    }

    private static Badge checkBenefitBadge(int totalBenefitAmount) {
        return Badge.findBadge(totalBenefitAmount);
    }
}
