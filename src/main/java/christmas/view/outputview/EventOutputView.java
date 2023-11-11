package christmas.view.outputview;

import static christmas.domain.event.EventConstants.EVENT_MONTH;

import christmas.domain.VisitDate;
import christmas.domain.dto.BenefitDto;
import christmas.domain.event.Badge;
import christmas.view.outputview.benefit.BenefitOutputView;
import christmas.view.outputview.messages.Category;

public class EventOutputView {
    private static final String EVENT_MSG = "%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

    public static void printEventMessage(VisitDate visitDate) {
        System.out.printf(EVENT_MSG, EVENT_MONTH.getValue(),visitDate.getDate());
        System.out.println();
    }

    public static void printBenefitSummary(BenefitDto benefits, int totalBenefitAmount, int expectedPayAmount) {
        BenefitOutputView.printBenefits(benefits);
        System.out.println();
        printResultAmount(totalBenefitAmount, expectedPayAmount);
        System.out.println();
    }

    public static void printBadge(Badge badge) {
        System.out.printf(Category.EVENT_BADGE.getMessage(), EVENT_MONTH.getValue());
        System.out.println();
        System.out.print(badge.getName());
    }

    private static void printResultAmount(int totalBenefitAmount, int expectedPayAmount) {
        printTotalBenefitAmount(totalBenefitAmount);
        System.out.println();
        printExpectedPayAmount(expectedPayAmount);
    }

    private static void printTotalBenefitAmount(int totalBenefitAmount) {
        System.out.println(Category.TOTAL_BENEFIT_AMOUNT.getMessage());
        System.out.printf("%,d원", totalBenefitAmount);
        System.out.println();
    }

    private static void printExpectedPayAmount(int expectedPayAmount) {
        System.out.println(Category.EXPECTED_PAY_AMOUNT.getMessage());
        System.out.printf("%,d원", expectedPayAmount);
        System.out.println();
    }
}
