package christmas.domain.event;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.restaurant.VisitDate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountPolicyTest {

    @Test
    @DisplayName("25일을 입력하면 크리스마스할인, 별데이 할인, 평일 할인이 적용되어야 한다.")
    void findDiscountPolicyTest() {
        VisitDate date = VisitDate.create("25");

        List<DiscountPolicy> discountPolicies = DiscountPolicy.findDiscountPolicies(date);

        assertTrue(discountPolicies.contains(DiscountPolicy.CHRISTMAS_DISCOUNT));
        assertTrue(discountPolicies.contains(DiscountPolicy.STAR_DAY_DISCOUNT));
        assertTrue(discountPolicies.contains(DiscountPolicy.WEEK_DAY_DISCOUNT));
    }

    @Test
    @DisplayName("29일을 입력하면 주말 할인만 적용되어야 한다.")
    void findDiscountPolicyOnlyWeekEndTest() {
        VisitDate date = VisitDate.create("29");

        List<DiscountPolicy> discountPolicies = DiscountPolicy.findDiscountPolicies(date);

        assertTrue(discountPolicies.contains(DiscountPolicy.WEEKEND_DISCOUNT));

        assertFalse(discountPolicies.contains(DiscountPolicy.CHRISTMAS_DISCOUNT));
        assertFalse(discountPolicies.contains(DiscountPolicy.STAR_DAY_DISCOUNT));
        assertFalse(discountPolicies.contains(DiscountPolicy.WEEK_DAY_DISCOUNT));
    }

    @Test
    @DisplayName("23일의 크리스마스 할인 금액은 3,300원이다.")
    void calcChristmasDiscountTest() {
        int date = 24;

        DiscountPolicy discountPolicy = DiscountPolicy.CHRISTMAS_DISCOUNT;
        int discountAmount = discountPolicy.getDiscountAmount(date);

        org.assertj.core.api.Assertions.assertThat(discountAmount).isEqualTo(-3_300);
    }

    @Test
    @DisplayName("메인 메뉴 2개의 주말 할인의 할인 금액은 4,046원이다.")
    void calcWeekendDiscountTest() {
        int mainMenuSize = 2;

        DiscountPolicy discountPolicy = DiscountPolicy.WEEKEND_DISCOUNT;
        int discountAmount = discountPolicy.getDiscountAmount(mainMenuSize);

        org.assertj.core.api.Assertions.assertThat(discountAmount).isEqualTo(-4_046);
    }

    @Test
    @DisplayName("별 데이 할인 정책이 적용됐다면 어떤 값을 넣어도 할인 금액은 1,000원이다.")
    void calcStarDayDiscountTest() {
        int anyValue = 2222;

        DiscountPolicy discountPolicy = DiscountPolicy.STAR_DAY_DISCOUNT;
        int discountAmount = discountPolicy.getDiscountAmount(anyValue);

        org.assertj.core.api.Assertions.assertThat(discountAmount).isEqualTo(-1_000);
    }
}