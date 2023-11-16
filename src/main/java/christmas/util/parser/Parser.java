package christmas.util.parser;

import static christmas.util.parser.ParseConstants.*;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public static int parseDate(String date) {
        return Integer.parseInt(date);
    }

    public static List<String> parseMenus(String orders) {
        return Arrays.stream(extractMenus(orders))
                .toList();
    }

    public static List<Integer> parseMenuCounts(String orders) {
        return Arrays.stream(extractCounts(orders))
                .filter(count -> isNotEmpty(count))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    private static String[] extractMenus(String orders) {
        return orders.split(EXTRACT_MENU.getRegex());
    }

    private static String[] extractCounts(String orders) {
        return orders.split(EXTRACT_MENU_COUNT.getRegex());
    }

    private static boolean isNotEmpty(String str) {
        return !str.isEmpty();
    }
}
