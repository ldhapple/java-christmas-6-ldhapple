package christmas.view.outputview.restaurant;

import static christmas.view.outputview.messages.MessageFormat.*;

import christmas.domain.restaurant.Orders;
import christmas.domain.food.Food;
import christmas.view.outputview.messages.Category;
import java.util.Map;

public class OrderOutputView {

    public static void printOrderSummary(Orders orders, int totalAmount) {
        printAllOrders(orders);
        printTotalAmount(totalAmount);
    }

    private static void printAllOrders(Orders orders) {
        System.out.println(Category.ORDER_MENU.getMessage());

        Map<Food, Integer> order = orders.getOrders();

        for (Map.Entry<Food, Integer> entry : order.entrySet()) {
            String foodName = entry.getKey()
                    .getName();
            int count = entry.getValue();

            System.out.printf(MENU.getFormat(), foodName);
            System.out.printf(MENU_COUNT.getFormat(), count);
            System.out.println();
        }
        System.out.println();
    }

    private static void printTotalAmount(int totalAmount) {
        System.out.println(Category.TOTAL_AMOUNT_BEFORE_DISCOUNT.getMessage());

        System.out.printf(MONEY.getFormat(), totalAmount);
        System.out.println();
    }
}
