package christmas.exception.order;

import static christmas.exception.ErrorMessage.*;

import christmas.exception.ErrorMessage;

public class InvalidOrderFormatException extends IllegalArgumentException {

    public InvalidOrderFormatException() {
        super(INVALID_ORDER_ERROR.getMessage());
    }
}
