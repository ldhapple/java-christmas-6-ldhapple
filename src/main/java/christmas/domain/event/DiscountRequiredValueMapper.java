package christmas.domain.event;

import christmas.domain.restaurant.Orders;
import christmas.domain.restaurant.VisitDate;
import java.util.EnumMap;

public class DiscountRequiredValueMapper {
    private final EnumMap<DiscountPolicy, Integer> discountRequiredValues;

    private DiscountRequiredValueMapper(VisitDate visitDate, Orders orders) {
        this.discountRequiredValues = initRequiredMapper(visitDate, orders);
    }

    public static DiscountRequiredValueMapper create(VisitDate visitDate, Orders orders) {
        return new DiscountRequiredValueMapper(visitDate, orders);
    }

    private static EnumMap<DiscountPolicy, Integer> initRequiredMapper(VisitDate visitDate,
                                                                       Orders orders) {

        EnumMap<DiscountPolicy, Integer> discountRequiredValues = new EnumMap<>(DiscountPolicy.class);

        discountRequiredValues.put(DiscountPolicy.CHRISTMAS_DISCOUNT, visitDate.getDate());
        discountRequiredValues.put(DiscountPolicy.WEEK_DAY_DISCOUNT, orders.getDessertMenuCount());
        discountRequiredValues.put(DiscountPolicy.WEEKEND_DISCOUNT, orders.getMainMenuCount());
        discountRequiredValues.put(DiscountPolicy.STAR_DAY_DISCOUNT, 0);

        return discountRequiredValues;
    }

    public int getRequiredValue(DiscountPolicy discountPolicy) {
        return discountRequiredValues.get(discountPolicy);
    }
}
