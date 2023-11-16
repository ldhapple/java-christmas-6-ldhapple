package christmas.exception;

public enum ErrorMessage {
    INVALID_VISIT_DATE_ERROR("유효하지 않은 날짜입니다."),
    INVALID_ORDER_ERROR("유효하지 않은 주문입니다."),
    EXCEED_ORDER_ERROR("메뉴는 총 20개 이하로만 주문 가능합니다."),
    ONLY_DRINK_ERROR("음료만 주문하실 수 없습니다.");

    private static final String HEADER = "[ERROR]";
    private static final String FOOTER = "다시 입력해 주세요.";
    private final String message;

    ErrorMessage(String bodyMessage) {
        this.message = String.format("%s %s %s", HEADER, bodyMessage, FOOTER);
    }

    public String getMessage() {
        return message;
    }
}
