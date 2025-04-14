package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.Searchable;

import java.util.*;

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

    public List searchBest(String search) throws BestResultNotFound {
        int maxQuantity = 0;

        List searchable = new ArrayList();
        Map<Integer, Searchable> searchableMap = new TreeMap<>((c1, c2) -> Double.valueOf(1.0 / c1).compareTo(Double.valueOf(1.0 / c2)));
        for (Searchable resource : list) {
            if (resource != null) {
                String str = resource.getSearchTerm();
                int localQuantity = 0;
                int index = 0;
                int searchIndex = str.indexOf(search, index);
                while (searchIndex != -1) {
                    localQuantity++;
                    index = searchIndex + search.length();
                    searchIndex = str.indexOf(search, index);
                }
                if (localQuantity > 0) {
                    searchableMap.put(localQuantity, resource);
                }
            }
        }
        if (searchableMap.get(1) == null) {
            throw new BestResultNotFound(search);
        }
        for (Map.Entry<Integer, Searchable> entry : searchableMap.entrySet()) {
            searchable.add(entry.getValue());
        }
        return searchable;
    }
}
