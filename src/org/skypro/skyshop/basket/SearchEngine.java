package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.Searchable;

import java.util.*;

public class SearchEngine {

    Set<Searchable> list = new HashSet<>();


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

    public TreeSet searchBest(String search) throws BestResultNotFound {
        int maxQuantity = 0;

        TreeSet searchable = new TreeSet();
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
                    searchable.add(resource);
                }
            }
        }
        if (searchable == null) {
            throw new BestResultNotFound(search);
        }
        return searchable;
    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            if (s1.length() == s2.length()) {
                return s2.compareTo(s1);
            }
            return s1.length()-s2.length();
        }
    }
}



