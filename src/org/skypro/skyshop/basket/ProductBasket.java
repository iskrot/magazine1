package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class ProductBasket {
    private List<Product> productBasket = new ArrayList<>();

    public void addProduct(Product product) {
        productBasket.add(product);
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
                if (product.getName().equals(name)) {
                    availability = true;
                }
            }
        }
        return availability;
    }

    public List<Product> remove(String name){
        List<Product> getList = new ArrayList<>();
        ListIterator<Product> iterator = productBasket.listIterator();
        while (iterator.hasNext()){
            Product product = iterator.next();
            if (product.getName().equals(name)){
                iterator.remove();
                getList.add(product);
            }
        }
        return getList;
    }

    public void basketClear() {
        productBasket.clear();
    }
}
