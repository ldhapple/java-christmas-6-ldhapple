package christmas.exception.visitdate;

import static christmas.exception.ErrorMessage.*;

import christmas.exception.ErrorMessage;

public class InvalidVisitDateFormatException extends IllegalArgumentException {

    public InvalidVisitDateFormatException() {
        super(INVALID_VISIT_DATE_ERROR.getMessage());
    }
}
