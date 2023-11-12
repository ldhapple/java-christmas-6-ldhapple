package christmas.domain.event;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.restaurant.Orders;
import christmas.domain.restaurant.VisitDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

class DiscountRequiredValueMapperTest {

    @Test
    @DisplayName("방문 날짜가 25일이면 CHRISTMAS_DISCOUNT 키 값에는 25가 입력된다.")
    void christmasRequiredValueTest() {
        VisitDate visitDate = VisitDate.create("25");
        Orders orders = BDDMockito.mock(Orders.class);

        DiscountRequiredValueMapper mapper = DiscountRequiredValueMapper.create(visitDate, orders);

        Assertions.assertEquals(25, mapper.getRequiredValue(DiscountPolicy.CHRISTMAS_DISCOUNT));
    }

    @Test
    @DisplayName("주문에 디저트메뉴 개수가 5개이면 WEEK_DAY_DISCOUNT 키 값에는 5가 입력된다.")
    void weekDayRequiredValueTest() {
        VisitDate visitDate = BDDMockito.mock(VisitDate.class);
        Orders orders = Orders.create("아이스크림-5,티본스테이크-3");

        DiscountRequiredValueMapper mapper = DiscountRequiredValueMapper.create(visitDate, orders);

        Assertions.assertEquals(5, mapper.getRequiredValue(DiscountPolicy.WEEK_DAY_DISCOUNT));
    }

    @Test
    @DisplayName("주문에 메인메뉴 개수가 3개이면 WEEKEND_DISCOUNT 키 값에는 3가 입력된다.")
    void weekendRequiredValueTest() {
        VisitDate visitDate = BDDMockito.mock(VisitDate.class);
        Orders orders = Orders.create("아이스크림-5,티본스테이크-3");

        DiscountRequiredValueMapper mapper = DiscountRequiredValueMapper.create(visitDate, orders);

        Assertions.assertEquals(3, mapper.getRequiredValue(DiscountPolicy.WEEKEND_DISCOUNT));
    }

    @Test
    @DisplayName("어떤 값이던 STAR_DAY_DISCOUNT 키 값에는 0이 입력된다.")
    void starDayRequiredValueTest() {
        VisitDate visitDate = BDDMockito.mock(VisitDate.class);
        Orders orders = BDDMockito.mock(Orders.class);

        DiscountRequiredValueMapper mapper = DiscountRequiredValueMapper.create(visitDate, orders);

        Assertions.assertEquals(0, mapper.getRequiredValue(DiscountPolicy.STAR_DAY_DISCOUNT));
    }
}