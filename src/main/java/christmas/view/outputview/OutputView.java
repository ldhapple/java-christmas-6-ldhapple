package christmas.view.outputview;

import christmas.domain.restaurant.Orders;
import christmas.domain.restaurant.VisitDate;
import christmas.dto.BenefitDto;
import christmas.domain.event.Badge;
import christmas.view.outputview.event.CautionOutputView;
import christmas.view.outputview.event.EventOutputView;
import christmas.view.outputview.restaurant.MenuOutputView;
import christmas.view.outputview.restaurant.OrderOutputView;

public class OutputView {

    public static void printHelloMessage() {
        EventOutputView.printEventHelloMessage();
        CautionOutputView.printCautions();
    }

    public static void printMenu() {
        MenuOutputView.printMenus();
        System.out.println();
    }

    public static void printEventPreviewMessage(VisitDate visitDate) {
        EventOutputView.printEventPreviewMessage(visitDate);
        System.out.println();
    }

    public static void printOrder(Orders orders, int totalAmount) {
        OrderOutputView.printOrderSummary(orders, totalAmount);
        System.out.println();
    }

    public static void printEventDetails(BenefitDto benefitDto, int totalBenefitAmount, int expectedPayAmount) {
        EventOutputView.printBenefitSummary(benefitDto, totalBenefitAmount, expectedPayAmount);
    }

    public static void printEventBadge(Badge badge) {
        EventOutputView.printBadge(badge);
    }
}
