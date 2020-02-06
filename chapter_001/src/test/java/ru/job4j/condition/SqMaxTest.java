package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {

    @Test
    public void whenFirstMax() {
        int result = SqMax.max(16, 4, 7, 5);
        assertThat(result, is(16));
    }

    @Test
    public void whenSecondMax() {
        int result = SqMax.max(6, 14, 7, 5);
        assertThat(result, is(14));
    }

    @Test
    public void whenThirdMax() {
        int result = SqMax.max(6, 4, 7, 5);
        assertThat(result, is(7));
    }

    @Test
    public void whenForthMax() {
        int result = SqMax.max(6, 4, 7, 15);
        assertThat(result, is(15));
    }

    @Test
    public void whenAllEquals() {
        int result = SqMax.max(10, 10, 10, 10);
        assertThat(result, is(10));
    }

    @Test
    public void whenOneMaxOtherEquals() {
        int result = SqMax.max(10, 15, 10, 10);
        assertThat(result, is(15));
    }

    @Test
    public void whenOneMinOtherEqualsAndMax() {
        int result = SqMax.max(10, 5, 10, 10);
        assertThat(result, is(10));
    }
}
