package christmas.view.outputview;

import christmas.domain.food.Appetizer;
import christmas.domain.food.Dessert;
import christmas.domain.food.Drink;
import christmas.domain.food.Food;
import christmas.domain.food.MainFood;
import java.text.DecimalFormat;
import java.util.Arrays;

public class MenuOutputView {

    public static void printMenus() {
        showAppetizerMenu();
        showMainMenu();
        showDessertMenu();
        showDrinkMenu();
    }

    private static void showAppetizerMenu() {
        System.out.println("<애피타이저>");
        StringBuilder menusView = setMenuView(Appetizer.class);
        System.out.println(menusView);
    }

    private static void showMainMenu() {
        System.out.println("<메인>");
        StringBuilder menusView = setMenuView(MainFood.class);
        System.out.println(menusView);
    }

    private static void showDessertMenu() {
        System.out.println("<디저트>");
        StringBuilder menusView = setMenuView(Dessert.class);
        System.out.println(menusView);
    }

    private static void showDrinkMenu() {
        System.out.println("<음료>");
        StringBuilder menusView = setMenuView(Drink.class);
        System.out.println(menusView);
    }

    private static StringBuilder setMenuView(Class<? extends Food> foodType) {
        StringBuilder menusView = new StringBuilder();

        for (Appetizer menu : Appetizer.values()) {
            menusView.append(menu.getMenuFormat()).append(", ");
        }

        removeLastComma(menusView);
        return menusView;
    }

    private static void removeLastComma(StringBuilder menusView) {
        if (menusView.length() > 0) {
            menusView.setLength(menusView.length() - 2);
        }
    }
}
