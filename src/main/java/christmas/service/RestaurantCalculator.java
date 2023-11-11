package christmas.service;

import christmas.domain.Orders;
import christmas.domain.food.Food;
import java.util.Map;
import java.util.Map.Entry;

public class RestaurantCalculator {
    public int getOrderTotalAmount(Orders orders) {
        int orderTotalPrice = 0;

        Map<Food, Integer> order = orders.getOrders();

        for (Entry<Food, Integer> entry : order.entrySet()) {
            Food orderFood = entry.getKey();
            int orderFoodPrice = orderFood.getPrice();
            int orderFoodCount = entry.getValue();

            orderTotalPrice += orderFoodPrice * orderFoodCount;
        }

        return orderTotalPrice;
    }
}
