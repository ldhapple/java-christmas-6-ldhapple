package christmas.domain;

import static christmas.domain.DecemberCalendar.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public enum SpecialDay {
    WEEKEND((date) -> date % 7 == WEEKEND_DAY.getDay() || date % 7 == WEEKEND_DAY.getSecondDay()),
    STAR((date) -> date % 7 == STAR_DAY.getDay()),
    WEEKDAY((date) -> date % 7 != WEEKEND_DAY.getDay() || date % 7 != WEEKEND_DAY.getSecondDay());

    private final Predicate<Integer> checker;

    SpecialDay(Predicate<Integer> checker) {
        this.checker = checker;
    }

    public static SpecialDay checkDayType(int date) {
        return Arrays.stream(SpecialDay.values())
                .filter(specialDay -> specialDay.checker.test(date))
                .findAny()
                .orElseThrow();
    }
}
