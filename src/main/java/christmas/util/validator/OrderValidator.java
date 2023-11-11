package christmas.util.validator;

import christmas.exception.order.InvalidOrderFormatException;
import christmas.util.parser.Parser;

public class OrderValidator {

    public static void validateOrders(String orders) {
        validateOrderFormat(orders);
        MenuValidator.validateMenus(Parser.parseMenus(orders));
        MenuCountValidator.validateCounts(Parser.parseMenuCounts(orders));
    }

    private static void validateOrderFormat(String orders) {
        if (isInvalidFormat(orders)) {
            throw new InvalidOrderFormatException();
        }
    }

    private static boolean isInvalidFormat(String orders) {
        return !InputValueFormat.ORDER
                .getPattern()
                .matcher(orders)
                .matches();
    }
}
