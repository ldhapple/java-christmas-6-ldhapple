package christmas.domain.event;

import static christmas.domain.calendar.DecemberCalendar.*;

import christmas.domain.restaurant.VisitDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum DiscountPolicy {
    CHRISTMAS_DISCOUNT("크리스마스 디데이 할인",
            (date) -> 1_000 + ((date - 1) * 100),
            (visitDate) -> visitDate.getDate() >= CHRISTMAS_EVENT_PERIOD.getStartDay()
                    && visitDate.getDate() <= CHRISTMAS_EVENT_PERIOD.getEndDay()),
    WEEKEND_DISCOUNT("주말 할인",
            (mainMenuCount) -> 2_023 * mainMenuCount,
            (visitDate) -> visitDate.getDate() % 7 == WEEKEND_DAY.getStartDay()
                    || visitDate.getDate() % 7 == WEEKEND_DAY.getEndDay()),
    STAR_DAY_DISCOUNT("특별 할인",
            (anyValue) -> 1_000,
            (visitDate) -> visitDate.getDate() % 7 == STAR_DAY.getStartDay()
                    || visitDate.getDate() == STAR_DAY.getEndDay()),
    WEEK_DAY_DISCOUNT("평일 할인",
            (dessertMenuCount) -> 2_023 * dessertMenuCount,
            (visitDate) -> visitDate.getDate() % 7 != WEEKEND_DAY.getStartDay()
                    && visitDate.getDate() % 7 != WEEKEND_DAY.getEndDay());

    private final String name;
    private final Function<Integer, Integer> discountAmountCalculator;
    private final Predicate<VisitDate> dateChecker;

    DiscountPolicy(String name, Function<Integer, Integer> discountAmountCalculator, Predicate<VisitDate> dateChecker) {
        this.name = name;
        this.discountAmountCalculator = discountAmountCalculator;
        this.dateChecker = dateChecker;
    }

    public static List<DiscountPolicy> findDiscountPolicies(VisitDate visitDate) {
        return Arrays.stream(DiscountPolicy.values())
                .flatMap(discountPolicy -> policyContainDate(visitDate, discountPolicy))
                .toList();
    }

    private static Stream<DiscountPolicy> policyContainDate(VisitDate date, DiscountPolicy discountPolicy) {
        if (discountPolicy.dateChecker.test(date)) {
            return Stream.of(discountPolicy);
        }
        return Stream.empty();
    }

    public String getName() {
        return name;
    }

    public int getDiscountAmount(int inputValue) {
        return discountAmountCalculator.apply(inputValue) * -1;
    }
}
