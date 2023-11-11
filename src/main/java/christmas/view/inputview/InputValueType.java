package christmas.view.inputview;

import christmas.domain.restaurant.Orders;
import christmas.domain.restaurant.VisitDate;
import java.util.function.Function;

public enum InputValueType {
    VISIT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)", VisitDate::create),
    ORDERS("주문하실 메뉴와 메뉴의 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)", Orders::create);

    private final String message;
    private final Function<String, Object> createFunction;

    InputValueType(String message, Function<String, Object> createFunction) {
        this.message = message;
        this.createFunction = createFunction;
    }

    public String getMessage() {
        return message;
    }

    public Function<String, Object> getCreateFunction() {
        return createFunction;
    }
}
