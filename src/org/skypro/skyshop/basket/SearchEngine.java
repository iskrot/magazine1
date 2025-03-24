package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Searchable;

public class SearchEngine {

    Searchable[] massive;

    public SearchEngine(int zine) {
        massive = new Searchable[zine];
    }

    public Searchable[] search(String request) {
        byte i = 0;
        Searchable[] result = new Searchable[5];
        for (Searchable resource : massive) {
            if (resource != null) {
                if (resource.getSearchTerm().contains(request)) {
                    result[i] = resource;
                    i++;
                }
            }
            if (i > 4) {
                break;
            }
        }
        return result;
    }

    public void add(Searchable searchable) {
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] == null) {
                massive[i] = searchable;
                searchable = null;
                break;
            }
        }
    }

    public Searchable searchBest(String search) throws BestResultNotFound {
        int maxQuantity = 0;

        Searchable searchable = null;
        for (Searchable resource : massive) {
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
