package christmas.domain.restaurant;

import christmas.domain.food.Dessert;
import christmas.domain.food.Food;
import christmas.domain.food.MainFood;
import christmas.util.parser.Parser;
import christmas.util.validator.OrderValidator;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Orders {
    private final Map<Food, Integer> orders;

    private Orders(String orders) {
        validate(orders);
        this.orders = registerOrders(orders);
    }

    public static Orders create(String orders) {
        return new Orders(orders);
    }

    public int getMainMenuCount() {
        int mainMenuCount = 0;

        for (Entry<Food, Integer> entry : orders.entrySet()) {
            Food menu = entry.getKey();
            int menuCount = entry.getValue();

            if (menu instanceof MainFood) {
                mainMenuCount += menuCount;
            }
        }

        return mainMenuCount;
    }

    public int getDessertMenuCount() {
        int dessertMenuCount = 0;

        for (Entry<Food, Integer> entry : orders.entrySet()) {
            Food menu = entry.getKey();
            int menuCount = entry.getValue();

            if (menu instanceof Dessert) {
                dessertMenuCount += menuCount;
            }
        }

        return dessertMenuCount;
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
