package christmas.exception.menucount;

import static christmas.exception.ErrorMessage.*;

import christmas.exception.ErrorMessage;

public class MenuTotalCountExceedMaxException extends IllegalArgumentException {

    public MenuTotalCountExceedMaxException() {
        super(EXCEED_ORDER_ERROR.getMessage());
    }
}
