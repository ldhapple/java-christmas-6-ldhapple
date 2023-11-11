package christmas.util.validator;

import christmas.domain.calendar.DecemberCalendar;
import christmas.exception.visitdate.InvalidRangeVisitDateException;
import christmas.exception.visitdate.InvalidVisitDateFormatException;
import christmas.util.parser.Parser;

public class VisitDateValidator {

    public static void validateVisitDate(String date) {
        validateVisitDateFormat(date);
        validateValidRangeDate(Parser.parseDate(date));
    }

    private static void validateVisitDateFormat(String date) {
        if (isInvalidFormat(date)) {
            throw new InvalidVisitDateFormatException();
        }
    }

    private static void validateValidRangeDate(int date) {
        if (isInValidRange(date)) {
            throw new InvalidRangeVisitDateException();
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
