package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.basket.SearchEngine;
import org.skypro.skyshop.product.*;

public class App {
    public static void main(String[] args) {
        Product[] listOfProducts = {new SimpleProduct("морковь", 40), new DiscountedProduct("огурец", 50, (byte) 20), new FixPriceProduct("молоко")};

        Article bigCup = new Article("Пол-литровая кружка", "Она настолько большая, что вы в ней утоните!!");
        Article bucket = new Article("Ведро с болтами", "Это... реально ведро с болтами. А вы чего-то другого ожидали?");
        Article slippers = new Article("Эко тапки", "Сделано из бутылок. Спасайте природу вместе с нами!!");

        ProductBasket basket = new ProductBasket();
        SearchEngine searchEngine = new SearchEngine(50);

        basket.printBasket();
        for (byte i = 0; i < 6; i++){
            basket.addProduct(listOfProducts[(byte) (Math.random()*3)]);
            searchEngine.add(listOfProducts[(byte) (Math.random()*3)]);
        }
        searchEngine.add(bigCup);
        searchEngine.add(bucket);
        searchEngine.add(slippers);

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
                System.out.println(i.SearchTerm());
            }
        }

        System.out.println();

        for (Searchable i : searchEngine.search("б")){
            if (i != null){
                System.out.println(i.SearchTerm());
            }
        }

        System.out.println();

        for (Searchable i : searchEngine.search("ко")){
            if (i != null){
                System.out.println(i.SearchTerm());
            }
        }

    }
}