package christmas.view.outputview.messages;

public enum Category {
    EVENT_CAUTION("이벤트 주의 사항"),
    ORDER_MENU("주문 메뉴"),
    TOTAL_AMOUNT_BEFORE_DISCOUNT("할인 전 총주문 금액"),
    BENEFIT_MENU("증정 메뉴"),
    BENEFIT_LIST("혜택 내역"),
    TOTAL_BENEFIT_AMOUNT("총혜택 금액"),
    EXPECTED_PAY_AMOUNT("할인 후 예상 결제 금액"),
    EVENT_BADGE("%d월 이벤트 배지");

    private static final String HEADER = "<";
    private static final String FOOTER = ">";

    private final String message;

    Category(String message) {
        this.message = String.format("%s%s%s", HEADER, message, FOOTER);;
    }

    public String getMessage() {
        return message;
    }
}
