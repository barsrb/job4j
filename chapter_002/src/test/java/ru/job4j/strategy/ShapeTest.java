package ru.job4j.strategy;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ShapeTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
            square.draw(),
                is(new StringJoiner(System.lineSeparator())
                        .add("+++++++")
                        .add("+     +")
                        .add("+     +")
                        .add("+++++++")
                        .toString()
                )
        );
    }

    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(new StringJoiner(System.lineSeparator())
                        .add("   +   ")
                        .add("  + +  ")
                        .add(" +   + ")
                        .add("+++++++")
                        .toString()
                )
        );
    }
}
