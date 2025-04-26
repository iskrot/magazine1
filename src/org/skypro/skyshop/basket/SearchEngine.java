package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.Searchable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchEngine {

    Set<Searchable> list = new HashSet<>();


    public TreeSet<Searchable> search(String search) throws BestResultNotFound {


        TreeSet<Searchable> result2 = new TreeSet<Searchable>();

        TreeSet<Searchable> result = (TreeSet<Searchable>) list.stream()
                .filter(i -> i.getSearchTerm().contains(search))
                .collect(Collectors.toCollection(() -> new TreeSet<Searchable>(new MyComparator())));

        if (result == null) {
            throw new BestResultNotFound(search);
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

    public static class MyComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            if (s1.getSearchTerm().length() == s2.getSearchTerm().length()) {
                return s2.getSearchTerm().compareTo(s1.getSearchTerm());
            }
            return s1.getSearchTerm().length()-s2.getSearchTerm().length();
        }
    }
}



