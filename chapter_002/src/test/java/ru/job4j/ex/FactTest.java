package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void testFactWithException() {
        Fact fact = new Fact();
        fact.calc(-4);
    }

    @Test
    public void testFactWithoutException() {
        Fact fact = new Fact();
        int result = fact.calc(4);
        int expect = 24;
        assertThat(result, is(expect));

    }
}
