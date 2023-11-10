package christmas.domain.food;

import java.util.Arrays;

public enum MainFood implements Food {

    STEAK("티본스테이크", 55_000),
    RIB("바비큐립", 54_000),
    SEAFOOD_PASTA("해산물파스타", 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000);

    private final String name;
    private final int price;

    MainFood(String name, int price) {
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
