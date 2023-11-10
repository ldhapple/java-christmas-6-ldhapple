package christmas.domain.event;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Badge {

    NO_BADGE("없음", (benefitAmount) -> benefitAmount * -1 < 5_000),
    SANTA_BADGE("산타", (benefitAmount) -> benefitAmount * -1 >= 20_000),
    TREE_BADGE("트리", (benefitAmount) -> benefitAmount * -1 >= 10_000),
    STAR_BADGE("별", (benefitAmount) -> benefitAmount * -1 >= 5_000);

    private final String name;
    private final Predicate<Integer> checker;

    Badge(String name, Predicate<Integer> checker) {
        this.name = name;
        this.checker = checker;
    }

    public static Badge findBadge(int benefitAmount) {
        return Arrays.stream(Badge.values())
                .filter((badge) -> badge.checker.test(benefitAmount))
                .findFirst()
                .orElse(NO_BADGE);
    }

    public String getName() {
        return name;
    }
}
