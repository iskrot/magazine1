package org.skypro.skyshop.product;

public abstract class Product implements Searchable{
    String name;
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
}
