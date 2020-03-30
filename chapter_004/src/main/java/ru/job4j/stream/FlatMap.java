package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public static List<Integer> flatMap(Integer[][] matrix) {
        List<List<Integer>> listMatrix = new ArrayList<>();
        for (Integer[] row : matrix) {
            listMatrix.add(Arrays.asList(row));
        }

        return listMatrix.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

}
