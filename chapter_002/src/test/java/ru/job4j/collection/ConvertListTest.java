package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertListTest {
    @Test
    public void whenTwoList() {
        List<Integer[]> in = new ArrayList<>();
        in.add(new Integer[] {1});
        in.add(new Integer[] {2, 3});
        List<Integer> expect = Arrays.asList(1, 2, 3);
        assertThat(ConvertList.convert(in), is(expect));
    }

    @Test
    public void whenOneList() {
        List<Integer[]> in = new ArrayList<>();
        in.add(new Integer[] {1, 2, 3});
        List<Integer> expect = Arrays.asList(1, 2, 3);
        assertThat(ConvertList.convert(in), is(expect));
    }

    @Test
    public void whenThreeList() {
        List<Integer[]> in = new ArrayList<>();
        in.add(new Integer[] {1});
        in.add(new Integer[] {2});
        in.add(new Integer[] {3});
        List<Integer> expect = Arrays.asList(1, 2, 3);
        assertThat(ConvertList.convert(in), is(expect));
    }
}