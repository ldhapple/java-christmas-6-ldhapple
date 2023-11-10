package christmas.view.outputview;

import christmas.domain.dto.BenefitDto;
import christmas.domain.event.DiscountPolicy;
import christmas.domain.food.Food;
import java.util.EnumMap;
import java.util.List;
import java.util.Map.Entry;

public class BenefitOutputView {

    public static void printBenefitSummary(BenefitDto benefits) {
        printBenefitMenu(benefits);
        printTotalBenefit(benefits);
    }

    private static void printBenefitMenu(BenefitDto benefits) {
        System.out.println("<증정 메뉴>");

        Food benefitFood = benefits.benefitFood();

        System.out.printf("%s", getBenefitFoodName(benefitFood));
        printBenefitFoodCount(benefitFood);

        System.out.println();
    }

    private static void printTotalBenefit(BenefitDto benefits) {
        System.out.println();
        System.out.println("<혜택 내역>");

        EnumMap<DiscountPolicy, Integer> discountResults = benefits.discountResults();
        Food benefitFood = benefits.benefitFood();
        StringBuilder result = new StringBuilder();

        for (Entry<DiscountPolicy, Integer> discountResult : discountResults.entrySet()) {
            DiscountPolicy discountPolicy = discountResult.getKey();
            int discountAmount = discountResult.getValue();
            String discountPolicyName = discountPolicy.getName();

            if (discountAmount != 0) {
                result.append(String.format("%s: %,d원", discountPolicyName, discountAmount));
                result.append("\n");
            }
        }

        if (benefitFood != null) {
            result.append(String.format("증정 이벤트: %,d원", benefitFood.getPrice() * -1));
            result.append("\n");
        }

        if (result.isEmpty()) {
            result.append("없음");
            result.append("\n");
        }

        System.out.print(result);
    }

    private static boolean hasBenefitFood(Food benefitFood) {
        return benefitFood != null;
    }

    private static void printBenefitFoodCount(Food benefitFood) {
        if (hasBenefitFood(benefitFood)) {
            System.out.printf(" %d개", 1);
        }
    }

    private static String getBenefitFoodName(Food benefitFood) {
        if (hasBenefitFood(benefitFood)) {
            return benefitFood.getName();
        }

        return "없음";
    }
}