package christmas.domain;

import christmas.domain.restaurant.VisitDate;
import christmas.exception.visitdate.InvalidRangeVisitDateException;
import christmas.exception.visitdate.InvalidVisitDateFormatException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("방문 날짜 입력 값 테스트")
class VisitDateTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "15", "31"})
    @DisplayName("정상 값 입력 테스트")
    void validValueInputTest(String dateValidInputValues) {
        Assertions.assertDoesNotThrow(() -> VisitDate.create(dateValidInputValues));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1일", "one", "1 3", "-1"})
    @DisplayName("숫자가 아닌 값을 입력했을 때 예외 발생")
    void invalidValueInputTest(String dateInvalidFormatInputValues) {
        Assertions.assertThrows(InvalidVisitDateFormatException.class, () -> {
           VisitDate.create(dateInvalidFormatInputValues);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "32"})
    @DisplayName("1~31 까지의 숫자가 아닌 값을 입력했을 때 예외 발생")
    void invalidRangeInputTest(String dateInvalidRangeInputValues) {
        Assertions.assertThrows(InvalidRangeVisitDateException.class, () -> {
            VisitDate.create(dateInvalidRangeInputValues);
        });
    }
}