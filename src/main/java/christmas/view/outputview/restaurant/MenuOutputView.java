package christmas.view.outputview.restaurant;

import static christmas.view.outputview.messages.MenuType.*;
import static christmas.view.outputview.messages.MessageFormat.*;

import christmas.domain.food.Appetizer;
import christmas.domain.food.Dessert;
import christmas.domain.food.Drink;
import christmas.domain.food.Food;
import christmas.domain.food.MainFood;
import christmas.view.outputview.messages.MessageFormat;

public class MenuOutputView {

    public static void printMenus() {
        printAppetizerMenu();
        printMainMenu();
        printDessertMenu();
        printDrinkMenu();
    }

    private static void printAppetizerMenu() {
        System.out.println(APPETIZER_TYPE.getMessage());

        StringBuilder menusView = getMenuView(Appetizer.class);
        System.out.println(menusView);
    }

    private static void printMainMenu() {
        System.out.println(MAIN_FOOD_TYPE.getMessage());

        StringBuilder menusView = getMenuView(MainFood.class);
        System.out.println(menusView);
    }

    private static void printDessertMenu() {
        System.out.println(DESSERT_TYPE.getMessage());

        StringBuilder menusView = getMenuView(Dessert.class);
        System.out.println(menusView);
    }

    private static void printDrinkMenu() {
        System.out.println(DRINK_TYPE.getMessage());

        StringBuilder menusView = getMenuView(Drink.class);
        System.out.println(menusView);
    }

    private static StringBuilder getMenuView(Class<? extends Food> foodType) {
        StringBuilder menusView = new StringBuilder();

        for (Enum<?> menu : foodType.asSubclass(Enum.class).getEnumConstants()) {
            menusView.append(((Food)menu).getFoodByMenuFormat())
                    .append(MENU_DELIMITER.getFormat());
        }

        removeLastDelimiter(menusView);
        return menusView;
    }

    private static void removeLastDelimiter(StringBuilder menusView) {
        if (menusView.length() > 0) {
            menusView.setLength(menusView.length() - 2);
        }
    }
}
