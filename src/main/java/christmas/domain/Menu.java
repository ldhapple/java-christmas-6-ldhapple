package christmas.domain;

import christmas.domain.food.Appetizer;
import christmas.domain.food.Dessert;
import christmas.domain.food.Drink;
import christmas.domain.food.Food;
import christmas.domain.food.MainFood;
import java.util.Arrays;
import java.util.stream.Stream;

public enum Menu {
    FOOD_MENU(Appetizer.class, MainFood.class, Dessert.class),
    DRINK_MENU(Drink.class);

    private final Class<? extends Food>[] foodTypes;

    @SafeVarargs
    Menu(Class<? extends Food>... foodTypes) {
        this.foodTypes = foodTypes;
    }

    public static boolean isFoodInMenu(String foodName) {
        return getFoodByName(foodName) != null;
    }

    public static Food getFoodByName(String foodName) {
        return iterateMenus()
                .filter(menu -> foodName.equals(menu.getName()))
                .findFirst()
                .orElse(null);
    }

    public static boolean isDrink(String foodName) {
        return iterateMenus()
                .anyMatch(menu -> foodName.equals(menu.getName()) &&
                        menuContainDrinkMenuType(menu));
    }

    private static boolean menuContainDrinkMenuType(Food food) {
        return Arrays.asList(Menu.DRINK_MENU.foodTypes)
                .contains(food.getClass());
    }

    private static Stream<? extends Food> iterateMenus() {
        return Arrays.stream(Menu.values())
                .flatMap(menu -> getMenuTypes(menu))
                .flatMap(menuType -> getMenu(menuType));
    }

    private static Stream<Class<? extends Food>> getMenuTypes(Menu menu) {
        return Arrays.stream(menu.foodTypes);
    }

    private static Stream<? extends Food> getMenu(Class<? extends Food> menuType) {
        return Arrays.stream(menuType.getEnumConstants());
    }
}
