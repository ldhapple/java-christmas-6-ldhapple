package christmas.util.validator;

public enum MenuCountConstants {
    MIN(0),
    MAX(20);

    private final int value;

    MenuCountConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
