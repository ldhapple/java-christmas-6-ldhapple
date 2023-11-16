package christmas.exception.order;

import static christmas.exception.ErrorMessage.*;

import christmas.exception.ErrorMessage;

public class OnlyDrinkOrderException extends IllegalArgumentException {

    public OnlyDrinkOrderException() {
        super(ONLY_DRINK_ERROR.getMessage());
    }
}
