package christmas.domain;

import christmas.domain.event.Badge;
import christmas.domain.restaurant.Orders;
import christmas.domain.restaurant.VisitDate;

public class Customer {
    private static Long nextId = 1L;

    private Long id;
    private final VisitDate visitDate;
    private final Orders orders;
    private final Badge badge;

    private Customer(VisitDate visitDate, Orders orders, Badge badge) {
        this.id = getNextId();
        this.visitDate = visitDate;
        this.orders = orders;
        this.badge = badge;
    }

    public static Customer create(VisitDate visitDate, Orders orders, Badge badge) {
        return new Customer(visitDate, orders, badge);
    }

    public Long getId() {
        return id;
    }

    private static Long getNextId() {
        return nextId++;
    }
}
