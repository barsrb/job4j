import org.junit.Assert;
import org.junit.Test;
import ru.job4j.condition.Point;

public class PointTest {
    @Test
    public void testPointDistance() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 0);

        double expected = 2.0;

        double result = p1.distance(p2);

        Assert.assertEquals(expected, result, 0.01);

        p1 = new Point(-1, -1);
        p2 = new Point(1, 1);

        expected = 2.8;

        result = p1.distance(p2);

        Assert.assertEquals(expected, result, 0.5);
    }
}
