package christmas.util.validator;

import java.util.List;

public class MenuCountValidator {

    public static void validateCounts(List<Integer> counts) {
        if (hasInvalidCount(counts)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean hasInvalidCount(List<Integer> counts) {
        return !counts.stream()
                .allMatch(count -> isValidCount(count));
    }

    private static boolean isValidCount(Integer count) {
        return biggerThanZero(count) && lessThanMaxCount(count);
    }

    private static boolean biggerThanZero(Integer count) {
        return count > MenuCountConstants.MIN.getValue();
    }

    private static boolean lessThanMaxCount(Integer count) {
        return count <= MenuCountConstants.MAX.getValue();
    }
}
