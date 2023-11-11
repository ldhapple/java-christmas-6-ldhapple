package christmas.view.outputview.event;

import christmas.view.outputview.messages.Category;
import christmas.view.outputview.messages.Caution;

public class CautionOutputView {

    public static void printCautions() {
        System.out.println(Category.EVENT_CAUTION.getMessage());
        printCaution();
        System.out.println();
    }

    private static void printCaution() {
        System.out.println(Caution.ORDER_AMOUNT.getMessage());
        System.out.println(Caution.ORDER_ONLY_DRINK.getMessage());
        System.out.println(Caution.ORDER_MAX_COUNT.getMessage());
        System.out.println(Caution.ORDER_EXAMPLE.getMessage());
    }
}
