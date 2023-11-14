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
        int orderTotalAmount = getOrderTotalAmount(orders);

        showEventPreviewMessage(visitDate);
        showOrderDetails(orders, orderTotalAmount);
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

    private int getOrderTotalAmount(Orders orders) {
        return restaurantCalculator.getOrderTotalAmount(orders);
    }

    private static void showEventPreviewMessage(VisitDate visitDate) {
        OutputView.printEventPreviewMessage(visitDate);
    }

    private static void showOrderDetails(Orders orders, int orderTotalAmount) {
        OutputView.printOrder(orders, orderTotalAmount);
    }

    private void executeEvent(VisitDate visitDate, Orders orders, int orderTotalAmount) {
        if (canApplyEvent(orderTotalAmount)) {
            eventPlanerController.executeEventPlaner(visitDate, orders, orderTotalAmount);
        }
    }

    private boolean canApplyEvent(int orderTotalAmount) {
        if (isOrderTotalAmountValidForEvent(orderTotalAmount)) {
            return true;
        }

        eventPlanerController.notApplyEvent(orderTotalAmount);
        return false;
    }

    private static boolean isOrderTotalAmountValidForEvent(int orderTotalAmount) {
        return orderTotalAmount >= EVENT_MIN_PAY_AMOUNT.getValue();
    }

    private Orders inputOrders() {
        return (Orders) InputView.inputValue(InputValueType.ORDERS);
    }

    private VisitDate inputVisitDate() {
        return (VisitDate) InputView.inputValue(InputValueType.VISIT_DATE);
    }
}
