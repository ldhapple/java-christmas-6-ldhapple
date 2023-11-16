package christmas.view.outputview.benefit;

import static christmas.view.outputview.messages.MessageFormat.*;

import christmas.domain.event.BenefitFood;
import christmas.dto.BenefitDto;
import christmas.view.outputview.messages.Category;

public class BenefitFoodOutputView {

    public static void printBenefitMenu(BenefitDto benefits) {
        System.out.println(Category.BENEFIT_MENU.getMessage());

        BenefitFood benefitFood = benefits.benefitFood();
        System.out.println(getBenefitMenu(benefitFood));

        System.out.println();
    }

    private static String getBenefitMenu(BenefitFood benefitFood) {
        if (existBenefitFood(benefitFood)) {
            return String.format("%s%s",
                    String.format(MENU.getFormat(), benefitFood.getFood().getName()),
                    String.format(MENU_COUNT.getFormat(), benefitFood.getCount())
            );
        }

        return NOTHING.getFormat();
    }

    private static boolean existBenefitFood(BenefitFood benefitFood) {
        return benefitFood.hasBenefitFood();
    }
}
