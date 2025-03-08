package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Objects;

public class ProductBasket {
    private Product[] productBasket = new Product[5];

    public void addProduct(Product product) {

        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = product;
                product = null;
                break;
            }
        }
        if (product != null) {
            System.out.println("Невозможно добавить продукт");
        }

    }

    public int getPlaceBasket() {
        int price = 0;
        for (Product place : productBasket) {
            if (place != null) {
                price += place.getPrice();
            }
        }
        return price;
    }

    public void printBasket() {
        boolean basketVacous = true;
        byte allIsSpecial = 0;
        for (Product product : productBasket) {
            if (product != null) {
                basketVacous = false;
                System.out.println(product.toString());
                if (product.isSpecial()) {
                    allIsSpecial++;
                }
            }
        }
        if (basketVacous) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println("Итого: " + getPlaceBasket());
            System.out.println("Специальных товаров: " + allIsSpecial);
        }
    }

    public boolean productSearch(String name) {
        boolean availability = false;
        for (Product product : productBasket) {
            if (product != null) {
                if (Objects.equals(product.getName(), name)) {
                    availability = true;
                }
            }
        }
        return availability;
    }

    public void basketClear() {
        productBasket = new Product[5];
    }
}
