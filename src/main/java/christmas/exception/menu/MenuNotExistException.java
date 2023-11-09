package christmas.exception.menu;

import static christmas.exception.ErrorMessage.*;

import christmas.exception.ErrorMessage;

public class MenuNotExistException extends IllegalArgumentException {

    public MenuNotExistException() {
        super(INVALID_ORDER_ERROR.getMessage());
    }
}
