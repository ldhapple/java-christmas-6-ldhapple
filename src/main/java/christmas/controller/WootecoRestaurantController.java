package christmas.controller;

import static christmas.domain.event.EventConstants.*;

import christmas.domain.restaurant.Orders;
import christmas.domain.restaurant.VisitDate;
import christmas.service.RestaurantCalculator;
import christmas.view.inputview.InputValueType;
import christmas.view.inputview.InputView;
import christmas.view.outputview.OutputView;

public class WootecoRestaurantController {

    private final RestaurantCalculator restaurantCalculator;
    private final EventPlanerController eventPlanerController;

    public WootecoRestaurantController(RestaurantCalculator restaurantCalculator,
                                       EventPlanerController eventPlanerController) {
        this.restaurantCalculator = restaurantCalculator;
        this.eventPlanerController = eventPlanerController;
    }

    public void takeReservation() {
        VisitDate visitDate = getVisitDate();
        Orders orders = getOrders();
        int orderTotalAmount = restaurantCalculator.getOrderTotalAmount(orders);

        OutputView.printEventPreviewMessage(visitDate);
        OutputView.printOrder(orders, orderTotalAmount);
        executeEvent(visitDate, orders, orderTotalAmount);
    }

    private VisitDate getVisitDate() {
        OutputView.printHelloMessage();
        VisitDate visitDate = inputVisitDate();
        return visitDate;
    }

    private Orders getOrders() {
        OutputView.printMenu();
        Orders orders = inputOrders();
        return orders;
    }

    private void executeEvent(VisitDate visitDate, Orders orders, int orderTotalAmount) {
        if (canApplyEvent(orderTotalAmount)) {
            eventPlanerController.executeEventPlaner(visitDate, orders, orderTotalAmount);
        }
    }

    private boolean canApplyEvent(int orderTotalAmount) {
        if (orderTotalAmount >= EVENT_MIN_AMOUNT.getValue()) {
            return true;
        }

        eventPlanerController.noEvent();
        return false;
    }

    private Orders inputOrders() {
        return (Orders) InputView.inputValue(InputValueType.ORDERS);
    }

    private VisitDate inputVisitDate() {
        return (VisitDate) InputView.inputValue(InputValueType.VISIT_DATE);
    }
}
