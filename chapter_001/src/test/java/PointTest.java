import org.junit.Assert;
import org.junit.Test;
import ru.job4j.condition.Point;

public class PointTest {
    @Test
    public void testPointDistance0020() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 0);

        double expected = 2.0;

        double result = p1.distance(p2);

        Assert.assertEquals(expected, result, 0.01);
    }

    @Test
    public void testPointDistance1111() {
        Point p1 = new Point(-1, -1);
        Point p2 = new Point(1, 1);

        double expected = 2.8;

        double result = p1.distance(p2);

        Assert.assertEquals(expected, result, 0.5);
    }

    @Test
    public void testPoint3Distance123456() {
        Point p1 = new Point(1, 2, 3);
        Point p2 = new Point(4, 5, 6);

        double expected = 5.2;

        double result = p1.distance3d(p2);

        Assert.assertEquals(expected, result, 0.1);
    }

    @Test
    public void testPoint3Distance00002222() {
        Point p1 = new Point(0, 0, 0);
        Point p2 = new Point(2, 2, 2);

        double expected = 3.46;

        double result = p1.distance3d(p2);

        Assert.assertEquals(expected, result, 0.1);
    }
}
