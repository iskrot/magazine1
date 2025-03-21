package org.skypro.skyshop.product;

public class SimpleProduct extends Product{
    private int price;

    public SimpleProduct(String name, int price) throws Exception {
        super(name);
        if (price <= 0){
            throw new IllegalArgumentException("Цена продукта должна быть больше нуля.");
        }
        this.price = price;

    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return name+": "+getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
