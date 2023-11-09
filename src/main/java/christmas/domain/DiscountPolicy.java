package christmas.domain;

import static christmas.domain.DecemberCalendar.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum DiscountPolicy {
    CHRISTMAS_DISCOUNT((date) -> 1_000 + ((date - 1) * 100),
            (date) -> date >= CHRISTMAS_EVENT_PERIOD.getFirstDay() && date <= CHRISTMAS_EVENT_PERIOD.getSecondDay()),
    WEEKEND_DISCOUNT((mainMenuCount) -> 2_023 * mainMenuCount,
            (date) -> date % 7 == WEEKEND_DAY.getFirstDay() || date % 7 == WEEKEND_DAY.getSecondDay()),
    STAR_DAY_DISCOUNT((anyValue) -> 1_000,
            (date) -> date % 7 == STAR_DAY.getFirstDay() || date == STAR_DAY.getSecondDay()),
    WEEK_DAY_DISCOUNT((dessertMenuCount) -> 2_023 * dessertMenuCount,
            (date) -> date % 7 != WEEKEND_DAY.getFirstDay() || date % 7 != WEEKEND_DAY.getSecondDay());

    private final Function<Integer, Integer> discountAmountCalculator;
    private final Predicate<Integer> dateChecker;

    DiscountPolicy(Function<Integer, Integer> discountAmountCalculator, Predicate<Integer> dateChecker) {
        this.discountAmountCalculator = discountAmountCalculator;
        this.dateChecker = dateChecker;
    }

    public static List<DiscountPolicy> findDiscountPolicies(int date) {
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

    public int getDiscountAmount(int inputValue) {
        return discountAmountCalculator.apply(inputValue) * -1;
    }
}
