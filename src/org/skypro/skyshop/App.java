package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        Product[] listOfProducts = {new SimpleProduct("морковь", 40), new DiscountedProduct("огурец", 50, (byte) 20), new FixPriceProduct("молоко")};
        ProductBasket basket = new ProductBasket();

        basket.printBasket();
        for (byte i = 0; i < 6; i++){
            basket.addProduct(listOfProducts[(byte) (Math.random()*3)]);
        }
        basket.printBasket();
        System.out.println(basket.getPlaceBasket());
        System.out.println(basket.productSearch("морковь"));
        System.out.println(basket.productSearch("банан"));
        basket.basketClear();
        basket.printBasket();
        System.out.println(basket.getPlaceBasket());
        System.out.println(basket.productSearch("морковь"));
    }
}