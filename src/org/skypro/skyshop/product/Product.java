package org.skypro.skyshop.product;

public abstract class Product implements Searchable{
    String name;
    String type = "PRODUCT";

    public Product(String name){
        this.name = name;

    }

    public String SearchTerm(){
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
}
