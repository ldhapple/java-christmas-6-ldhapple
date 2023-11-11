package christmas.util.parser;

public enum ParseConstants {
    EXTRACT_MENU("-\\d+,*"),
    EXTRACT_MENU_COUNT(",*[가-힣]+-");

    private final String regex;

    ParseConstants(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
