package christmas.util.validator;

import christmas.domain.DecemberCalendar;
import java.util.regex.Pattern;

public class VisitDateValidator {

    public static void validateVisitDateFormat(String date) {
        if (isInvalidFormat(date)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateValidRangeDate(int date) {
        if (isInValidRange(date)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInvalidFormat(String date) {
        return !InputValueFormat.VISIT_DATE
                .getPattern()
                .matcher(date)
                .matches();
    }

    private static boolean isInValidRange(int date) {
        return isLessDate(date) || isExceedDate(date);
    }

    private static boolean isExceedDate(int date) {
        return date > DecemberCalendar.OTHER_EVENT_PERIOD.getSecondDay();
    }

    private static boolean isLessDate(int date) {
        return date < DecemberCalendar.OTHER_EVENT_PERIOD.getFirstDay();
    }
}
