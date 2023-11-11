package christmas.util.validator;

import static christmas.domain.event.EventConstants.*;

import christmas.domain.event.EventConstants;
import christmas.exception.menucount.MenuCountLessThanOneException;
import christmas.exception.menucount.MenuTotalCountExceedMaxException;
import java.util.List;

public class MenuCountValidator {

    public static void validateCounts(List<Integer> counts) {
        validateAMenuCount(counts);
        validateTotalCount(counts);
    }

    private static void validateAMenuCount(List<Integer> counts) {
        if (hasInvalidCount(counts)) {
            throw new MenuCountLessThanOneException();
        }
    }

    private static void validateTotalCount(List<Integer> counts) {
        if (isInvalidTotalCount(counts)) {
            throw new MenuTotalCountExceedMaxException();
        }
    }

    private static boolean isInvalidTotalCount(List<Integer> counts) {
        int totalMenuCount = counts.stream()
                .mapToInt(x -> x)
                .sum();

        return biggerThanMax(totalMenuCount);
    }

    private static boolean hasInvalidCount(List<Integer> counts) {
        return !counts.stream()
                .allMatch(count -> isValidCount(count));
    }

    private static boolean isValidCount(Integer count) {
        return biggerThanMin(count);
    }

    private static boolean biggerThanMin(Integer count) {
        return count >= MIN_ORDER_COUNT.getValue();
    }

    private static boolean biggerThanMax(int totalMenuCount) {
        return totalMenuCount > MAX_ORDER_COUNT.getValue();
    }
}
