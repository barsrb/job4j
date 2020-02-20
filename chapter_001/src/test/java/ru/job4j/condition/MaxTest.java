package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax5To3Then5() {
        int result = Max.max(5, 3);
        assertThat(result, is(5));
    }

    @Test
    public void whenMax4To4Then4() {
        int result = Max.max(4, 4);
        assertThat(result, is(4));
    }

    @Test
    public void maxOfTree() {
        int result = Max.max(5, 3, 8);
        assertThat(result, is(8));
    }

    @Test
    public void maxOfFour() {
        int result = Max.max(5, 3, 9, 2);
        assertThat(result, is(9));
    }
}
