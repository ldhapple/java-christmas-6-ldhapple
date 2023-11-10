package christmas.view.inputview;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Function;

public class InputView {

    public static Object inputValue(InputValueType inputValueType) {
        while(true) {
            try {
                printInputMessage(inputValueType.getMessage());

                Function<String, Object> createFunction = inputValueType.getCreateFunction();
                String input = Console.readLine();

                return createFunction.apply(input);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    private static void printInputMessage(String inputMessage) {
        System.out.println(inputMessage);
    }

    private static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
