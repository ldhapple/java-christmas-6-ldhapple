package christmas;

import christmas.controller.EventPlanerController;
import christmas.controller.WootecoRestaurantController;
import christmas.service.EventCalculator;
import christmas.service.RestaurantCalculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        WootecoRestaurantController restaurantController = new WootecoRestaurantController(new RestaurantCalculator(),
                new EventPlanerController(new EventCalculator()));

        restaurantController.takeReservation();
    }
}
