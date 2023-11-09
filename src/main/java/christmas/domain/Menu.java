package christmas.domain;

import christmas.domain.food.Appetizer;
import christmas.domain.food.Dessert;
import christmas.domain.food.Drink;
import christmas.domain.food.Food;
import christmas.domain.food.MainFood;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public enum Menu {
    FOOD_MENU(Appetizer.class, MainFood.class, Dessert.class),
    DRINK_MENU(Drink.class);

    private final Class<? extends Food>[] menuTypes;

    @SafeVarargs
    Menu(Class<? extends Food>... foodTypes) {
        this.menuTypes = foodTypes;
    }

    public static boolean isFoodInMenu(String foodName) {
        return getFoodByName(foodName) != null;
    }

    public static Food getFoodByName(String foodName) {
        return iterateFoods()
                .filter(food -> foodName.equals(food.getName()))
                .findFirst()
                .orElse(null);
    }

    public static boolean isDrink(String foodName) {
        return iterateFoods()
                .anyMatch(food -> foodName.equals(food.getName()) &&
                        foodContainDrinkMenuType(food));
    }

    private static boolean foodContainDrinkMenuType(Food food) {
        return Arrays.asList(Menu.DRINK_MENU.getMenuTypes())
                .contains(food.getClass());
    }

    private static Stream<? extends Food> iterateFoods() {
        return Arrays.stream(Menu.values())
                .flatMap(menus -> getFoodTypes(menus))
                .flatMap(foodType -> getFoods(foodType));
    }

    private static Stream<Class<? extends Food>> getFoodTypes(Menu menu) {
        return Arrays.stream(menu.getMenuTypes());
    }

    private static Stream<? extends Food> getFoods(Class<? extends Food> foodType) {
        return Arrays.stream(foodType.getEnumConstants());
    }

    private Class<? extends Food>[] getMenuTypes() {
        return menuTypes;
    }
}
