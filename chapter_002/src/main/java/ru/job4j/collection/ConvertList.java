package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertList {
    public static List<Integer> convert(List<Integer[]> list) {
        List<Integer[]> rsl = new ArrayList<>(list);
        return rsl.stream().flatMap(Arrays::stream).collect(Collectors.toList());
    }
}