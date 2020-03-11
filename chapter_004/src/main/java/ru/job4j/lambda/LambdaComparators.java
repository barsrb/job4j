package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaComparators {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("aaaaaaaaa");
        stringList.add("cccccc");
        stringList.add("bbbb");

        Comparator<String> cmpText = (left, right) ->  left.compareTo(right);

        stringList.sort(cmpText);
        System.out.println(stringList);

        Comparator<String> cmpDescSize = (left, right) -> right.length() - left.length();
        stringList.sort(cmpDescSize);
        System.out.println(stringList);
    }
}
