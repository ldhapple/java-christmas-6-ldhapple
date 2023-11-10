package christmas.domain.food;

import java.util.Arrays;

public enum Dessert implements Food {

    CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000);

    private final String name;
    private final int price;

    Dessert(String name, int price) {
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
