package christmas.util.validator;

import christmas.domain.restaurant.Menu;
import christmas.exception.menu.DuplicateMenuException;
import christmas.exception.menu.MenuNotExistException;
import christmas.exception.order.OnlyDrinkOrderException;
import java.util.List;

public class MenuValidator {

    public static void validateMenus(List<String> menus) {
        validateExistMenus(menus);
        validateOnlyDrink(menus);
        validateDuplicateMenu(menus);
    }

    private static void validateExistMenus(List<String> menus) {
        if (hasNotExistsMenu(menus)) {
            throw new MenuNotExistException();
        }
    }

    private static void validateOnlyDrink(List<String> menus) {
        if (isOnlyDrink(menus)) {
            throw new OnlyDrinkOrderException();
        }
    }

    private static void validateDuplicateMenu(List<String> menus) {
        if (hasDuplicatedMenu(menus)) {
            throw new DuplicateMenuException();
        }
    }

    private static boolean hasNotExistsMenu(List<String> menus) {
        return !menus.stream()
                .allMatch(menu -> Menu.isFoodInMenu(menu));
    }

    private static boolean isOnlyDrink(List<String> menus) {
        return menus.stream()
                .allMatch(menu -> Menu.isDrink(menu));
    }

    private static boolean hasDuplicatedMenu(List<String> menus) {
        long uniqueMenuCount = menus.stream()
                .distinct()
                .count();

        return uniqueMenuCount != menus.size();
    }
}
