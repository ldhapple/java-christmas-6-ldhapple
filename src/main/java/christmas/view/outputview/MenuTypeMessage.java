package christmas.view.outputview;

public enum MenuTypeMessage {
    APPETIZER_TYPE("애피타이저"),
    MAIN_FOOD_TYPE("메인"),
    DESSERT_TYPE("디저트"),
    DRINK_TYPE("음료");

    private static final String HEADER = "<";
    private static final String FOOTER = ">";

    private final String message;

    MenuTypeMessage(String message) {
        this.message = String.format("%s %s %s", HEADER, message, FOOTER);;
    }

    public String getMessage() {
        return message;
    }
}
