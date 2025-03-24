package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Searchable;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    List<Searchable> list = new ArrayList<>();



    public ArrayList<Searchable> search(String request) {

        ArrayList<Searchable> result = new ArrayList<>();
        for (Searchable resource : list) {
            if (resource != null) {
                if (resource.getSearchTerm().contains(request)) {
                    result.add(resource);
                }
            }

        }
        return result;
    }

    public void add(Searchable searchable) {
        list.add(searchable);
    }

    public Searchable searchBest(String search) throws BestResultNotFound {
        int maxQuantity = 0;

        Searchable searchable = null;
        for (Searchable resource : list) {
            if (resource != null) {
                String str =  resource.getSearchTerm();
                int localQuantity = 0;
                int index = 0;
                int searchIndex = str.indexOf(search, index);
                while (searchIndex != -1) {
                    localQuantity++;
                    index = searchIndex + search.length();
                    searchIndex = str.indexOf(search, index);
                }
                if (localQuantity > maxQuantity) {
                    searchable = resource;
                }
            }
        }
        if (searchable == null){
            throw new BestResultNotFound(search);
        }
        return searchable;
    }
}
