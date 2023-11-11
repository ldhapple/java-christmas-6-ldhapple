package christmas.view.outputview.benefit;

import static christmas.view.outputview.messages.MessageFormat.*;

import christmas.domain.event.BenefitFood;
import christmas.dto.BenefitDto;
import christmas.domain.event.DiscountPolicy;
import christmas.domain.food.Food;
import christmas.view.outputview.messages.Category;
import java.util.EnumMap;
import java.util.Map.Entry;

public class BenefitOutputView {

    public static void printBenefits(BenefitDto benefits) {
        BenefitFoodOutputView.printBenefitMenu(benefits);
        printBenefitList(benefits);
    }

    private static void printBenefitList(BenefitDto benefits) {
        System.out.println(Category.BENEFIT_LIST.getMessage());

        StringBuilder result = new StringBuilder();
        EnumMap<DiscountPolicy, Integer> discountResults = benefits.discountResults();
        BenefitFood benefitFood = benefits.benefitFood();

        printBenefitLists(result, discountResults);
        printBenefitFoodEvent(result, benefitFood);
        printIfNoBenefit(result);

        System.out.println(result);
    }

    private static void printBenefitLists(StringBuilder result, EnumMap<DiscountPolicy, Integer> discountResults) {
        for (Entry<DiscountPolicy, Integer> discountResult : discountResults.entrySet()) {
            DiscountPolicy discountPolicy = discountResult.getKey();
            String discountPolicyName = discountPolicy.getName();
            int discountAmount = discountResult.getValue();

            if (isAppliedDiscountPolicy(discountAmount)) {
                result.append(String.format(DISCOUNT_POLICY.getFormat(), discountPolicyName));
                result.append(String.format(MONEY.getFormat(), discountAmount));
                result.append("\n");
            }
        }
    }

    private static void printBenefitFoodEvent(StringBuilder result, BenefitFood benefitFood) {
        if (benefitFood.hasBenefitFood()) {
            Food bonusFood = benefitFood.getFood();
            result.append(BENEFIT_FOOD_EVENT.getFormat());
            result.append(String.format(MONEY.getFormat(), bonusFood.getPrice() * -1));
            result.append(LINE_SPACE.getFormat());
        }
    }

    private static void printIfNoBenefit(StringBuilder result) {
        if (hasNoBenefit(result)) {
            result.append(NOTHING.getFormat());
            result.append(LINE_SPACE.getFormat());
        }
    }

    private static boolean isAppliedDiscountPolicy(int discountAmount) {
        return discountAmount != 0;
    }

    private static boolean hasNoBenefit(StringBuilder result) {
        return result.isEmpty();
    }
}
