package christmas.domain.food;

import java.util.Arrays;

public enum Drink implements Food {

    ZERO_COKE("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000);

    private final String name;
    private final int price;

    Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getFoodByMenuFormat() {
        return String.format("%s(%,d)", name, price);
    }
}
