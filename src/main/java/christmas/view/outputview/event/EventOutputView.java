package christmas.view.outputview.event;

import static christmas.domain.event.EventConstants.EVENT_MONTH;
import static christmas.view.outputview.messages.MessageFormat.*;

import christmas.domain.VisitDate;
import christmas.domain.dto.BenefitDto;
import christmas.domain.event.Badge;
import christmas.view.outputview.benefit.BenefitOutputView;
import christmas.view.outputview.messages.Category;
import christmas.view.outputview.messages.MessageFormat;

public class EventOutputView {

    public static void printEventHelloMessage() {
        System.out.printf(HELLO_MESSAGE.getFormat(), EVENT_MONTH.getValue());
        System.out.println();

        System.out.println();
    }

    public static void printEventPreviewMessage(VisitDate visitDate) {
        System.out.printf(EVENT_PREV_MESSAGE.getFormat(), EVENT_MONTH.getValue(), visitDate.getDate());
        System.out.println();
    }

    public static void printBenefitSummary(BenefitDto benefits, int totalBenefitAmount, int expectedPayAmount) {
        BenefitOutputView.printBenefits(benefits);
        printResultAmount(totalBenefitAmount, expectedPayAmount);
    }

    public static void printBadge(Badge badge) {
        System.out.printf(Category.EVENT_BADGE.getMessage(), EVENT_MONTH.getValue());
        System.out.println();

        System.out.print(badge.getName());
    }

    private static void printResultAmount(int totalBenefitAmount, int expectedPayAmount) {
        printTotalBenefitAmount(totalBenefitAmount);
        printExpectedPayAmount(expectedPayAmount);
    }

    private static void printTotalBenefitAmount(int totalBenefitAmount) {
        System.out.println(Category.TOTAL_BENEFIT_AMOUNT.getMessage());

        System.out.printf(MONEY.getFormat(), totalBenefitAmount);
        System.out.println();

        System.out.println();
    }

    private static void printExpectedPayAmount(int expectedPayAmount) {
        System.out.println(Category.EXPECTED_PAY_AMOUNT.getMessage());

        System.out.printf(MONEY.getFormat(), expectedPayAmount);
        System.out.println();

        System.out.println();
    }
}
