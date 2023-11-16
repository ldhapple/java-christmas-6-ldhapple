package christmas.domain.food;

public enum MenuFormat {
    MENU_FORMAT("%s(%,d)");

    private final String format;

    MenuFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
