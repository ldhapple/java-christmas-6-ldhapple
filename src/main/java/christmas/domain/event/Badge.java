package christmas.domain.event;

import java.util.function.Predicate;

public enum Badge {

    NO_BADGE("없음", (benefitAmount) -> benefitAmount < 5_000),
    STAR_BADGE("별", (benefitAmount) -> benefitAmount >= 5_000),
    TREE_BADGE("트리", (benefitAmount) -> benefitAmount >= 10_000),
    SANTA_BADGE("산타", (benefitAmount) -> benefitAmount >= 20_000);

    private final String name;
    private final Predicate<Integer> checker;

    Badge(String name, Predicate<Integer> checker) {
        this.name = name;
        this.checker = checker;
    }
}
