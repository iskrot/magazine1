package org.skypro.skyshop.product;

public class Article implements Searchable {
    String name;
    String text;
    String type = "ARTICLE";

    public Article(String name, String text){
        this.name = name;
        this.text = text;
    }

    public String getType(){
        return "Article";
    }
    public String SearchTerm(){
        return toString();
    }


    public String getStringRepresentation(){
        return name + "—" + type;
    }

    @Override
    public String toString() {
        return
                name + '\n' +
                 text;
    }
}
