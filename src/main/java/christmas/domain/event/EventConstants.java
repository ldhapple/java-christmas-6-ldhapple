package christmas.domain.event;

public enum EventConstants {
    EVENT_MONTH(12),
    MIN_ORDER_COUNT(1),
    MAX_ORDER_COUNT(20),
    BENEFIT_MENU_MIN_PAY_AMOUNT(120_000),
    BENEFIT_MENU_COUNT(1),
    EVENT_MIN_PAY_AMOUNT(10_000);

    private final int value;

    EventConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
