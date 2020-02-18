package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenExist() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(1, 1);
        Triangle triangle = new Triangle(a, b, c);
        boolean result = triangle.exist();
        assertThat(result, is(true));
    }

    @Test
    public void whenNotExist() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 3);
        Point c = new Point(0, 1);
        Triangle triangle = new Triangle(a, b, c);
        boolean result = triangle.exist();
        assertThat(result, is(false));
    }

    @Test
    public void period() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(1, 1);
        Triangle triangle = new Triangle(a, b, c);
        double period = 2.414;
        assertEquals(triangle.period(), period, 0.001);
    }

    @Test
    public void area() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(1, 1);
        Triangle triangle = new Triangle(a, b, c);
        double area = 1;
        assertEquals(triangle.area(), area, 0.001);
    }

    @Test
    public void areaWhenNotExists() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 3);
        Point c = new Point(0, 1);
        Triangle triangle = new Triangle(a, b, c);
        double area = -1;
        assertEquals(triangle.area(), area, 0.001);
    }
}