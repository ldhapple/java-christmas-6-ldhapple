package christmas.domain.event;

import static christmas.domain.DecemberCalendar.*;

import christmas.domain.VisitDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum DiscountPolicy {

    CHRISTMAS_DISCOUNT("크리스마스 디데이 할인",
            (date) -> 1_000 + ((date - 1) * 100),
            (date) -> date >= CHRISTMAS_EVENT_PERIOD.getFirstDay() && date <= CHRISTMAS_EVENT_PERIOD.getSecondDay()),
    WEEKEND_DISCOUNT("주말 할인",
            (mainMenuCount) -> 2_023 * mainMenuCount,
            (date) -> date % 7 == WEEKEND_DAY.getFirstDay() || date % 7 == WEEKEND_DAY.getSecondDay()),
    STAR_DAY_DISCOUNT("특별 할인",
            (anyValue) -> 1_000,
            (date) -> date % 7 == STAR_DAY.getFirstDay() || date == STAR_DAY.getSecondDay()),
    WEEK_DAY_DISCOUNT("평일 할인",
            (dessertMenuCount) -> 2_023 * dessertMenuCount,
            (date) -> date % 7 != WEEKEND_DAY.getFirstDay() && date % 7 != WEEKEND_DAY.getSecondDay());

    private final String name;
    private final Function<Integer, Integer> discountAmountCalculator;
    private final Predicate<Integer> dateChecker;

    DiscountPolicy(String name, Function<Integer, Integer> discountAmountCalculator, Predicate<Integer> dateChecker) {
        this.name = name;
        this.discountAmountCalculator = discountAmountCalculator;
        this.dateChecker = dateChecker;
    }

    public static List<DiscountPolicy> findDiscountPolicies(VisitDate visitDate) {
        int date = visitDate.getDate();
        return Arrays.stream(DiscountPolicy.values())
                .flatMap(discountPolicy -> policyContainDate(date, discountPolicy))
                .toList();
    }

    private static Stream<DiscountPolicy> policyContainDate(int date, DiscountPolicy discountPolicy) {
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
