package christmas.view.outputview.benefit;

import static christmas.view.outputview.messages.MessageFormat.*;

import christmas.domain.BenefitFood;
import christmas.domain.dto.BenefitDto;
import christmas.view.outputview.messages.Category;
import christmas.view.outputview.messages.MessageFormat;

public class BenefitFoodOutputView {

    public static void printBenefitMenu(BenefitDto benefits) {
        System.out.println(Category.BENEFIT_MENU.getMessage());

        BenefitFood benefitFood = benefits.benefitFood();

        if (!benefitFood.hasBenefitFood()) {
            System.out.print(NOTHING.getFormat());
        } else if (benefitFood.hasBenefitFood()) {
            System.out.printf(MENU.getFormat(), benefitFood.getFood().getName());
            System.out.printf(MENU_COUNT.getFormat(), benefitFood.getCount());
        }
        System.out.println();

        System.out.println();
    }
}
