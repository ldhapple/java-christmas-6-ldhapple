package christmas.exception.menucount;

import static christmas.exception.ErrorMessage.*;

public class MenuCountLessThanOneException extends IllegalArgumentException {

    public MenuCountLessThanOneException() {
        super(INVALID_ORDER_ERROR.getMessage());
    }
}
