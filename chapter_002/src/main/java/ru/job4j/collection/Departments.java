package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        List<String> rsl;
        HashSet<String> tmp = new HashSet<>();
        for (String value : deps) {
            StringBuilder start = new StringBuilder();
            for (String el : value.split("/")) {
                tmp.add(start + el);
                start.append(el).append("/");
            }
        }
        rsl = new ArrayList<>(tmp);
        return rsl;
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        Comparator<String> comparator = new HeadDepDescComparator().thenComparing(Comparator.naturalOrder());
        orgs.sort(comparator);
    }

    private static class HeadDepDescComparator implements Comparator<String> {
        @Override
        public int compare(String left, String right) {
            String leftHead = left.contains("/") ? left.substring(0, left.indexOf("/")) : left;
            String rightHead = right.contains("/") ? right.substring(0, right.indexOf("/")) : right;
            return rightHead.compareTo(leftHead);
        }
    }

}