package christmas.exception.visitdate;

import static christmas.exception.ErrorMessage.*;

import christmas.exception.ErrorMessage;

public class InvalidRangeVisitDateException extends IllegalArgumentException {

    public InvalidRangeVisitDateException() {
        super(INVALID_VISIT_DATE_ERROR.getMessage());
    }
}
