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

    public void run() {
        OutputView.printHelloMessage();
        VisitDate visitDate = inputVisitDate();
        OutputView.printMenu();
        Orders orders = inputOrders();
        eventPlanerController.executeEventPlaner(visitDate, orders);
    }

    private Orders inputOrders() {
        return (Orders) InputView.inputValue(InputValueType.ORDERS);
    }

    private VisitDate inputVisitDate() {
        return (VisitDate) InputView.inputValue(InputValueType.VISIT_DATE);
    }
}
