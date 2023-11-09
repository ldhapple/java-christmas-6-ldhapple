package christmas.util.validator;

import christmas.domain.Menu;
import christmas.util.Parser;
import java.util.List;
import java.util.regex.Pattern;

public class OrderValidator {

    public static void validateOrders(String orders) {
        validateOrderFormat(orders);
        MenuValidator.validateMenus(Parser.parseMenus(orders));
        MenuCountValidator.validateCounts(Parser.parseMenuCounts(orders));
    }

    private static void validateOrderFormat(String orders) {
        if (isInvalidFormat(orders)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInvalidFormat(String orders) {
        return !InputValueFormat.ORDER
                .getPattern()
                .matcher(orders)
                .matches();
    }
}
