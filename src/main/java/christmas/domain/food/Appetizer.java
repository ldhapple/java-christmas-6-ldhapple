package christmas.domain.food;

import christmas.domain.food.Food;
import java.util.Arrays;

public enum Appetizer implements Food {

    SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_500),
    SALAD("시저샐러드", 8_000);

    private final String name;
    private final int price;

    Appetizer(String name, int price) {
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
    public String getMenuFormat() {
        return String.format("%s(%,d)", name, price);
    }
}
