package christmas;

import christmas.controller.EventPlanerController;
import christmas.controller.WootecoRestaurantController;
import christmas.service.EventCalculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        WootecoRestaurantController controller = new WootecoRestaurantController(
                new EventPlanerController(new EventCalculator()));

        controller.run();
    }
}
