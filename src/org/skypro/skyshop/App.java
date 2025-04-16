package org.skypro.skyshop;

import org.skypro.skyshop.basket.BestResultNotFound;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.basket.SearchEngine;
import org.skypro.skyshop.product.*;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Product[] listOfProducts = {new SimpleProduct("морковь", 40), new DiscountedProduct("огурец", 50, (byte) 20), new FixPriceProduct("молоко")};

        Article bigCup = new Article("Пол-литровая кружка", "Она настолько большая, что вы в ней утоните!!");
        Article bucket = new Article("Ведро с болтами", "Это... реально ведро с болтами. А вы чего-то другого ожидали?");
        Article slippers = new Article("Эко тапки", "Сделано из бутылок. Спасайте природу вместе с нами!!");

        ProductBasket basket = new ProductBasket();
        SearchEngine searchEngine = new SearchEngine();

        basket.printBasket();
        for (byte i = 0; i < 6; i++){
            basket.addProduct(listOfProducts[(byte) (Math.random()*3)]);
            searchEngine.add(listOfProducts[(byte) (Math.random()*3)]);
        }

        searchEngine.add(bigCup);
        searchEngine.add(bucket);
        searchEngine.add(slippers);
        searchEngine.add(slippers);
        searchEngine.add(new Article("морковъ", "куда тверже обычной моркови"));

        basket.printBasket();
        System.out.println(basket.getPlaceBasket());
        System.out.println(basket.productSearch("морковь"));
        System.out.println(basket.productSearch("банан"));
        basket.basketClear();
        basket.printBasket();
        System.out.println(basket.getPlaceBasket());
        System.out.println(basket.productSearch("морковь"));


        for (Searchable i : searchEngine.search("ре")){
            if (i != null){
                System.out.println(i.getSearchTerm());
            }
        }

        System.out.println();

        for (Searchable i : searchEngine.search("б")){
            if (i != null){
                System.out.println(i.getSearchTerm());
            }
        }

        System.out.println();

        for (Searchable i : searchEngine.search("ко")){
            if (i != null){
                System.out.println(i.getSearchTerm());
            }
        }

        try {
            SimpleProduct test = new SimpleProduct(null, 1);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            SimpleProduct test = new SimpleProduct("", 1);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            SimpleProduct test = new SimpleProduct("null", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            DiscountedProduct test = new DiscountedProduct("nlul", 1, (byte) 101);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        System.out.println(searchEngine.searchBest("в"));

        try {
            System.out.println(searchEngine.searchBest("jk"));
        }catch (BestResultNotFound e){
            System.out.println(e);
        }


        for (byte i = 0; i < 6; i++){
            basket.addProduct(listOfProducts[(byte) (Math.random()*3)]);
            searchEngine.add(listOfProducts[(byte) (Math.random()*3)]);
        }

        System.out.println(basket.remove("молоко"));
        basket.printBasket();
        if (basket.remove("d").size() == 0){
            System.out.println("Список пуст");
        }
        basket.printBasket();


        System.out.println(searchEngine.searchBest("морков"));

    }
}