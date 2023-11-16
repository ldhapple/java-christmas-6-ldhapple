package christmas.exception.menu;

import static christmas.exception.ErrorMessage.*;

import christmas.exception.ErrorMessage;

public class DuplicateMenuException extends IllegalArgumentException {

    public DuplicateMenuException() {
        super(INVALID_ORDER_ERROR.getMessage());
    }
}
