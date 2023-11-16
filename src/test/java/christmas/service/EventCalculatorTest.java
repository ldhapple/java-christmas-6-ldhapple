package christmas.service;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.event.BenefitFood;
import christmas.domain.event.DiscountPolicy;
import christmas.domain.restaurant.Orders;
import christmas.domain.restaurant.VisitDate;
import java.util.EnumMap;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventCalculatorTest {

    private EventCalculator eventCalculator;
    private VisitDate visitDate;
    private Orders orders;

    @BeforeEach
    void set() {
        eventCalculator = new EventCalculator();
        visitDate = VisitDate.create("25");
        orders = Orders.create("아이스크림-3,크리스마스파스타-3,제로콜라-3");
    }

    @Test
    @DisplayName("25일에 해당하는 할인 정책들을 key로, 방문일,주문에 맞게 할인 금액을 계산한 결과를 value로 정상반환하는지 검증")
    void getDiscountResultTest() {
        List<DiscountPolicy> discountPolicies = DiscountPolicy.findDiscountPolicies(visitDate);

        EnumMap<DiscountPolicy, Integer> discountResult = eventCalculator.getDiscountResult(discountPolicies, visitDate,
                orders);

        Assertions.assertEquals(-3_400, discountResult.get(DiscountPolicy.CHRISTMAS_DISCOUNT));
        Assertions.assertEquals(-6_069, discountResult.get(DiscountPolicy.WEEK_DAY_DISCOUNT));
        Assertions.assertEquals(-1_000, discountResult.get(DiscountPolicy.STAR_DAY_DISCOUNT));
    }

    @Test
    @DisplayName("증정메뉴가 있을 때, 증정메뉴 -25,000원, 할인 총액 -10,469원의 합을 정상 계산하는 지 검증")
    void getTotalBenefitAmountTestWithBenefitFood() {
        List<DiscountPolicy> discountPolicies = DiscountPolicy.findDiscountPolicies(visitDate);
        EnumMap<DiscountPolicy, Integer> discountResult = eventCalculator.getDiscountResult(discountPolicies, visitDate,
                orders);
        BenefitFood benefitFood = BenefitFood.createBenefitFood(120_000);

        int totalBenefitAmount = eventCalculator.getTotalBenefitAmount(discountResult, benefitFood);

        Assertions.assertEquals(-35_469, totalBenefitAmount);
    }

    @Test
    @DisplayName("증정메뉴가 없을 때, 할인 총액 -10,469원 정상 계산하는 지 검증")
    void getTotalBenefitAmountTestWithNoBenefitFood() {
        List<DiscountPolicy> discountPolicies = DiscountPolicy.findDiscountPolicies(visitDate);
        EnumMap<DiscountPolicy, Integer> discountResult = eventCalculator.getDiscountResult(discountPolicies, visitDate,
                orders);
        BenefitFood benefitFood = BenefitFood.createBenefitFood(5_500);

        int totalBenefitAmount = eventCalculator.getTotalBenefitAmount(discountResult, benefitFood);

        Assertions.assertEquals(-10_469, totalBenefitAmount);
    }

    @Test
    @DisplayName("증정 메뉴가 있으면, 최종 혜택 금액은 혜택 총액에서 증정메뉴의 가격을 뺸 가격인 -10,469원이어야 한다.")
    void getFinalBenefitAmountTestWithBenefitFood() {
        List<DiscountPolicy> discountPolicies = DiscountPolicy.findDiscountPolicies(visitDate);
        EnumMap<DiscountPolicy, Integer> discountResult = eventCalculator.getDiscountResult(discountPolicies, visitDate,
                orders);
        BenefitFood benefitFood = BenefitFood.createBenefitFood(120_000);
        int totalBenefitAmount = eventCalculator.getTotalBenefitAmount(discountResult, benefitFood);

        int finalBenefitAmount = eventCalculator.getFinalBenefitAmount(totalBenefitAmount, benefitFood);

        Assertions.assertEquals(-10_469, finalBenefitAmount);
    }
}