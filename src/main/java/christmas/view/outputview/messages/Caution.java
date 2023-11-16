package christmas.view.outputview.messages;

public enum Caution {
    ORDER_AMOUNT("- 총 주문 금액 10,000원 이상부터 이벤트가 적용됩니다."),
    ORDER_ONLY_DRINK("- 음료만 주문 시, 주문할 수 없습니다."),
    ORDER_MAX_COUNT("- 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다."),
    ORDER_EXAMPLE("  (e.g. 시저샐러드-1,티본스테이크-1,크리스마스파스타-1,제로콜라-3,아이스크림-1의 총 개수는 7개)");

    private final String message;

    Caution(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
