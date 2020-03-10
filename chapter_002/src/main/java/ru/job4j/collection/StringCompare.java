package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = left.length() - right.length();
        int compareLength = result  > 0 ? right.length() : left.length();
        for (int index = 0; index < compareLength; index++) {
            if (left.charAt(index) != right.charAt(index)) {
                return left.charAt(index) - right.charAt(index);
            }
        }
        return result;
    }
}