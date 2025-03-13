package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int price;
    private byte discounted;

    public DiscountedProduct(String name, int price, byte discounted) {
        super(name);
        this.price = price;
        this.discounted = discounted;
    }

    @Override
    public int getPrice() {
        return (price * (100 - discounted)) / 100;
    }

    @Override
    public String toString() {
        return name + ": " + price + " (скидка: " + discounted + ")";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }


}
