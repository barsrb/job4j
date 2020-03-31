package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FlatMapTest {

    @Test
    public void flatTest() {
        Integer[][] matrix = new Integer[][]{{1, 2}, {3, 4}, {5, 6}};
        List<Integer> flat = FlatMap.flatMap(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertThat(flat, is(expected));
    }

}