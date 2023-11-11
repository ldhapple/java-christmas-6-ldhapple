package christmas.domain.restaurant;

import static christmas.util.parser.Parser.*;

import christmas.util.validator.VisitDateValidator;

public class VisitDate {

    private final int date;

    private VisitDate(String date) {
        validate(date);
        this.date = parseDate(date);
    }

    public static VisitDate create(String date) {
        return new VisitDate(date);
    }

    private void validate(String date) {
        VisitDateValidator.validateVisitDate(date);
    }

    public int getDate() {
        return date;
    }
}
