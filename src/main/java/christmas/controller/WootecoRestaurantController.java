package christmas.controller;

import christmas.domain.Orders;
import christmas.domain.VisitDate;
import christmas.view.inputview.InputValueType;
import christmas.view.inputview.InputView;
import christmas.view.outputview.OutputView;

public class WootecoRestaurantController {

    private final EventPlanerController eventPlanerController;

    public WootecoRestaurantController(EventPlanerController eventPlanerController) {
        this.eventPlanerController = eventPlanerController;
    }

    public void takeReservation() {
        VisitDate visitDate = getVisitDate();
        Orders orders = getOrders();

        applyEvent(visitDate, orders);
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

    private void applyEvent(VisitDate visitDate, Orders orders) {
        eventPlanerController.executeEventPlaner(visitDate, orders);
    }

    private Orders inputOrders() {
        return (Orders) InputView.inputValue(InputValueType.ORDERS);
    }

    private VisitDate inputVisitDate() {
        return (VisitDate) InputView.inputValue(InputValueType.VISIT_DATE);
    }
}
