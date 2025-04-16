package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product extends NameInterface implements Searchable, Comparable{
    String type = "PRODUCT";


    public Product(String name) throws Exception {
        if (name == null){
            throw new IllegalArgumentException("У продукта должно быть имя.");
        }
        else if (name.isBlank()){
            throw new IllegalArgumentException("Имя продукта не может состоять из пробелов.");
        }
        this.name = name;

    }

    public String getSearchTerm(){
        return name;
    }

    public String getStringRepresentation(){
        return name + "—" + type;
    }

    public String getType(){
        return type;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    @Override
    public abstract String toString();

    public abstract boolean isSpecial();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Object o) {

        NameInterface product = (NameInterface) o;

        if (name.length() == product.name.length()){
            return name.compareTo(product.name);
        }
        return product.name.length()-name.length();

    }
}
