package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class ProductBasket {
    private Map<String, ArrayList<Product>> productBasket = new HashMap<>();

    public void addProduct(Product product) {
        ArrayList<Product> list = productBasket.getOrDefault(product.getName(), new ArrayList<Product>());
        list.add(product);
        productBasket.put(product.getName(), list);
    }

    public int getPlaceBasket() {
        int price = 0;
        for (Map.Entry<String, ArrayList<Product>> entry : productBasket.entrySet()) {
            for (Product place : entry.getValue()) {
                if (place != null) {
                    price += place.getPrice();
                }

            }
        }
        return price;
    }

    public void printBasket() {
        boolean basketVacous = true;
        byte allIsSpecial = 0;
        for (Map.Entry<String, ArrayList<Product>> entry : productBasket.entrySet()) {
            for (Product product : entry.getValue()) {
                if (product != null) {
                    basketVacous = false;
                    System.out.println(product.toString());
                    if (product.isSpecial()) {
                        allIsSpecial++;
                    }
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
        for (Map.Entry<String, ArrayList<Product>> entry : productBasket.entrySet()) {
            if (entry.getKey().equals(name)) {
                availability = true;
            }
        }
        return availability;
    }

    public List<Product> remove(String name) {

        List<Product> getList = productBasket.getOrDefault(name, new ArrayList<>());
        productBasket.remove(name);
        return getList;
    }

    public void basketClear() {
        productBasket.clear();
    }
}
