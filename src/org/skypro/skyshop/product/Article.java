package org.skypro.skyshop.product;

import java.util.Objects;

public class Article extends NameInterface implements Searchable, Comparable {
    String text;
    String type = "ARTICLE";

    public Article(String name, String text){
        this.name = name;
        this.text = text;
    }

    public String getType(){
        return "Article";
    }
    public String getSearchTerm(){
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public int compareTo(Object o) {
        NameInterface article = (NameInterface) o;

        if (name.length() == article.name.length()){
            return name.compareTo(article.name);
        }
        return article.name.length()-name.length();

    }
}
