package christmas.view.outputview;

import christmas.domain.Orders;
import christmas.domain.food.Food;
import java.util.Map;

public class OrderMenuOutputView {

    public static void printOrderSummary(Orders orders, int totalAmount) {
        printAllOrders(orders);
        printTotalAmount(totalAmount);
    }

    private static void printAllOrders(Orders orders) {
        System.out.println("<주문 메뉴>");

        Map<Food, Integer> order = orders.getOrders();

        for (Map.Entry<Food, Integer> entry : order.entrySet()) {
            String foodName = entry.getKey()
                    .getName();
            int count = entry.getValue();

            System.out.printf("%s %d개", foodName, count);
            System.out.println();
        }
    }

    private static void printTotalAmount(int totalAmount) {
        System.out.println("할인 전 총주문 금액");
        System.out.printf("%,d원", totalAmount);
        System.out.println();
    }
}
