package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Searchable;

public class SearchEngine {

    Searchable[] massive;

    public SearchEngine (int zine){
        massive = new Searchable[zine];
    }

    public Searchable[] search(String request){
        byte i = 0;
        Searchable[] result = new Searchable[5];
        for (Searchable resource : massive){
            if (resource != null){
                if (resource.SearchTerm().contains(request)){
                    result[i] = resource;
                    i++;
                }
            }
            if (i > 4){
                break;
            }
        }
        return result;
    }

    public void add(Searchable searchable){
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] == null) {
                massive[i] = searchable;
                searchable = null;
                break;
            }
        }
    }
}
