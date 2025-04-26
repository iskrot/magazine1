package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.stream.Stream;

public class ProductBasket {
    private Map<String, ArrayList<Product>> productBasket = new HashMap<>();

    public void addProduct(Product product) {
        ArrayList<Product> list = productBasket.getOrDefault(product.getName(), new ArrayList<Product>());
        list.add(product);
        productBasket.put(product.getName(), list);
    }

    public int getPlaceBasket() {
        return productBasket.values().stream().flatMap(Collection::stream).mapToInt(i -> i.getPrice()).sum();

    }

    public void printBasket() {
        boolean basketVacous = productBasket.size() < 2;

        byte allIsSpecial = (byte) productBasket.values().stream().flatMap(Collection::stream).filter(i -> i.isSpecial()).toList().size();

        if (basketVacous) {
            System.out.println("в корзине пусто");
        } else {
            List<String> stream = productBasket.values().stream().flatMap(Collection::stream).map(i -> i.toString() + "\n").toList();
            System.out.println(stream);
            System.out.println("Итого: " + getPlaceBasket());
            System.out.println("Специальных товаров: " + allIsSpecial);
        }
    }

    public boolean productSearch(String name) {
        return productBasket.values().stream().flatMap(Collection::stream).filter(i -> i.getName().equals(name)).toList().size() > 1;
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
