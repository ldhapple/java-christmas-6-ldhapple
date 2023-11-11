package christmas.view.outputview.messages;

public enum MessageFormat {
    HELLO_MESSAGE("안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다."),
    EVENT_PREV_MESSAGE("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    MONEY("%,d원"),
    DISCOUNT_POLICY("%s: "),
    BENEFIT_FOOD_EVENT("증정 이벤트: "),
    MENU("%s "),
    MENU_COUNT("%d개"),
    MENU_DELIMITER(", "),
    LINE_SPACE("\n"),
    NOTHING("없음");

    private final String format;

    MessageFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
