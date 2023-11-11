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
        BenefitFood benefitFood = BenefitFood.createBenefitFood(orderTotalAmount);
        BenefitDto benefits = BenefitDto.create(discountResults, benefitFood);

        int totalBenefitAmount = eventCalculator.getTotalBenefitAmount(discountResults, benefitFood);
        int lastBenefitAmount = eventCalculator.getLastBenefitAmount(totalBenefitAmount, benefitFood);
        int expectedPayAmount = eventCalculator.getExpectedPayAmount(orderTotalAmount, lastBenefitAmount);

        Badge benefitBadge = Badge.findBadge(totalBenefitAmount);

        showEventResult(benefits, totalBenefitAmount, expectedPayAmount, benefitBadge);
    }

    public void noEvent() {
        EnumMap<DiscountPolicy, Integer> discountResults = new EnumMap<>(DiscountPolicy.class);
        BenefitDto benefits = BenefitDto.create(discountResults, BenefitFood.NO_BENEFIT_FOOD);

        showNothingEventResult(benefits);
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

    private static void showNothingEventResult(BenefitDto benefits) {
        showEventResult(benefits, 0, 0, Badge.NO_BADGE);
    }
}
