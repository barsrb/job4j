package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {

    @Test
    public void whenFirstMax() {
        SqMax check = new SqMax();
        int result = check.max(16, 4, 7, 5);
        assertThat(result, is(16));
    }

    @Test
    public void whenThirdMax() {
        SqMax check = new SqMax();
        int result = check.max(6, 4, 7, 5);
        assertThat(result, is(7));
    }

    @Test
    public void whenAllEquals() {
        SqMax check = new SqMax();
        int result = check.max(10, 10, 10, 10);
        assertThat(result, is(10));
    }
}
