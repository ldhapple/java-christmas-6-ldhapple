package christmas.view.outputview.benefit;

import christmas.domain.BenefitFood;
import christmas.domain.dto.BenefitDto;
import christmas.view.outputview.messages.Category;

public class BenefitFoodOutputView {

    public static void printBenefitMenu(BenefitDto benefits) {
        System.out.println(Category.BENEFIT_MENU.getMessage());

        BenefitFood benefitFood = benefits.benefitFood();

        if (!benefitFood.hasBenefitFood()) {
            System.out.print("없음");
        } else if (benefitFood.hasBenefitFood()) {
            System.out.printf("%s %d개", benefitFood.getFood().getName(), benefitFood.getCount());
        }

        System.out.println();
    }
}
