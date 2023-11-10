package christmas.view.outputview;

import christmas.domain.Orders;
import christmas.domain.VisitDate;
import christmas.domain.dto.BenefitDto;
import christmas.domain.event.Badge;

public class OutputView {

    private static final String HELLO_MSG = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_MSG = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

    public static void printHelloMessage() {
        System.out.println(HELLO_MSG);
        System.out.println();
        printCaution();
    }

    public static void printMenu() {
        System.out.println();
        MenuOutputView.printMenus();
        System.out.println();
    }

    public static void printEventMessage(VisitDate visitDate) {
        System.out.printf(EVENT_MSG, visitDate.getDate());
        System.out.println();
        System.out.println();
    }

    public static void printOrder(Orders orders, int totalAmount) {
        OrderMenuOutputView.printOrderSummary(orders, totalAmount);
        System.out.println();
    }

    public static void printBenefits(BenefitDto benefitDto) {
        BenefitOutputView.printBenefitSummary(benefitDto);
    }

    public static void printResultAmount(int totalBenefitAmount, int expectedPayAmount) {
        System.out.println();
        System.out.println("<총혜택 금액>");
        System.out.printf("%,d원",totalBenefitAmount);
        System.out.println();
        System.out.println();

        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원", expectedPayAmount);
        System.out.println();
        System.out.println();
    }

    public static void printBadge(Badge badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.print(badge.getName());
    }

    private static void printCaution() {
        System.out.println("<이벤트 주의 사항>");
        System.out.println("- 총 주문 금액 10,000원 이상부터 이벤트가 적용됩니다.");
        System.out.println("- 음료만 주문 시, 주문할 수 없습니다.");
        System.out.println("- 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
        System.out.println("  (e.g. 시저샐러드-1,티본스테이크-1,크리스마스파스타-1,제로콜라-3,아이스크림-1의 총 개수는 7개");
        System.out.println();
    }
}
