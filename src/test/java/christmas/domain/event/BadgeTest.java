package christmas.domain.event;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BadgeTest {

    @Test
    @DisplayName("혜택 금액이 5,000원 이하이면 배지는 없다.")
    void noBadgeTest() {
        int benefitAmount = -3_500;
        Badge badge = Badge.findBadge(benefitAmount);

        Assertions.assertEquals(Badge.NO_BADGE, badge);
    }

    @Test
    @DisplayName("혜택 금액이 5,000원 이상 10,000원 미만이면 배지는 별.")
    void starBadgeTest() {
        int benefitAmount = -5_500;
        Badge badge = Badge.findBadge(benefitAmount);

        Assertions.assertEquals(Badge.STAR_BADGE, badge);
    }

    @Test
    @DisplayName("혜택 금액이 10,000원 이상 20,000원 미만이면 배지는 트리.")
    void treeBadgeTest() {
        int benefitAmount = -10_000;
        Badge badge = Badge.findBadge(benefitAmount);

        Assertions.assertEquals(Badge.TREE_BADGE, badge);
    }

    @Test
    @DisplayName("혜택 금액이 20,000원 이상이면 이면 배지는 트리.")
    void santaBadgeTest() {
        int benefitAmount = -20_000;
        Badge badge = Badge.findBadge(benefitAmount);

        Assertions.assertEquals(Badge.SANTA_BADGE, badge);
    }
}