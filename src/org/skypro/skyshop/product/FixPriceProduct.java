package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private final int price = 100;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ": " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
