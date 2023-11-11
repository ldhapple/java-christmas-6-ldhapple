package christmas.util;

public enum EventConstants {
    EVENT_MONTH(12);

    private final int value;

    EventConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
