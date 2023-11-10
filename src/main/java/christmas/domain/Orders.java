package christmas.domain;

import christmas.domain.food.Food;
import christmas.util.Parser;
import christmas.util.validator.MenuCountValidator;
import christmas.util.validator.MenuValidator;
import christmas.util.validator.OrderValidator;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orders {

    private final Map<Food, Integer> orders;

    private Orders(String orders) {
        validate(orders);
        this.orders = registerOrders(orders);
    }

    public static Orders create(String orders) {
        return new Orders(orders);
    }

    private void validate(String orders) {
        OrderValidator.validateOrders(orders);
    }

    private Map<Food, Integer> registerOrders(String orders) {
        List<String> menus = Parser.parseMenus(orders);
        List<Integer> counts = Parser.parseMenuCounts(orders);
        Map<Food, Integer> order = new HashMap<>();

        for (int idx = 0; idx < menus.size(); idx++) {
            String menuName = menus.get(idx);
            Food food = Menu.getFoodByName(menuName);
            int count = counts.get(idx);

            order.put(food, count);
        }
        return order;
    }

    public Map<Food, Integer> getOrders() {
        return Collections.unmodifiableMap(orders);
    }
}
