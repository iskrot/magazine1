package org.skypro.skyshop.basket;

public class BestResultNotFound extends Exception{
    String search;

    public BestResultNotFound (String search){
        this.search = search;
    }

    @Override
    public String toString() {
        return "BestResultNotFound {\n" +
                "На запрос ("+search+") ничего не найдено.}";
    }
}
