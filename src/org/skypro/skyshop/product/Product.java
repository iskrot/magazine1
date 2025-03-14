package org.skypro.skyshop.product;

public abstract class Product {
    String name;

    public Product(String name){
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    @Override
    public abstract String toString();

    public abstract boolean isSpecial();
}
