package christmas.service;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.restaurant.Orders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RestaurantCalculatorTest {

    @Test
    @DisplayName("아이스크림-5,000원, 티본스테이크-55,000원, 크리스마스파스타-25,000원, 제로콜라-3,000원, 타파스-5,500원 총합 93,500원 검증")
    void getOrderTotalAmountTest() {
        Orders orders = Orders.create("아이스크림-1,티본스테이크-1,크리스마스파스타-1,제로콜라-1,타파스-1");
        RestaurantCalculator restaurantCalculator = new RestaurantCalculator();

        int orderTotalAmount = restaurantCalculator.getOrderTotalAmount(orders);

        Assertions.assertEquals(93_500, orderTotalAmount);
    }
}