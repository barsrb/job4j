package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MultiMaxTest {
    @Test
    public void whenFirstMax() {
        MultiMax check = new MultiMax();
        int result = check.max(10, 4, 2);
        assertThat(result, is(10));
    }

    @Test
    public void whenSecondMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenThirdMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 12);
        assertThat(result, is(12));
    }

    @Test
    public void whenTwoEqualsAndMax() {
        MultiMax check = new MultiMax();
        int result = check.max(7, 3, 7);
        assertThat(result, is(7));
    }

    @Test
    public void whenTwoEqualsAndNotMax() {
        MultiMax check = new MultiMax();
        int result = check.max(6, 2, 6);
        assertThat(result, is(6));
    }

    @Test
    public void whenAllEquals() {
        MultiMax check = new MultiMax();
        int result = check.max(3, 3, 3);
        assertThat(result, is(3));
    }
}