package christmas.domain;

import java.util.regex.Pattern;

public class VisitDate {
    private static final Pattern visitDateRegex = Pattern.compile("\\d+");
    //숫자 1개 이상일 경우 허용

    private final int date;

    private VisitDate(String date) {
        validate(date);
        this.date = parseDate(date);
    }

    public static VisitDate create(String date) {
        return new VisitDate(date);
    }

    private void validate(String date) {
        validateFormat(date);
        validateValidDate(parseDate(date));
    }

    private void validateFormat(String date) {
        if (isInvalidFormat(date)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateValidDate(int date) {
        if (isInValidRange(date)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInvalidFormat(String date) {
        return !visitDateRegex.matcher(date).matches();
    }

    private boolean isInValidRange(int date) {
        return date < DecemberCalendar.FIRST_DAY.getDay() || date > DecemberCalendar.LAST_DAY.getDay();
    }

    private static int parseDate(String date) {
        return Integer.parseInt(date);
    }
}
