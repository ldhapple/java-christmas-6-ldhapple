package christmas.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String extractMenusRegex = "-\\d+,*";
    private static final String extractCountsRegex = ",*[가-힣]+-";

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
        return orders.split(extractMenusRegex);
    }

    private static String[] extractCounts(String orders) {
        return orders.split(extractCountsRegex);
    }

    private static boolean isNotEmpty(String str) {
        return !str.isEmpty();
    }
}
