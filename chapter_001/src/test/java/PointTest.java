import org.junit.Assert;
import org.junit.Test;
import ru.job4j.condition.Point;

public class PointTest {
    @Test
    public void testPointDistance(){
        int x1 = 0;
        int y1 = 0;
        int x2 = 2;
        int y2 = 0;

        double expected = 2.0;

        double result = Point.distance(x1, y1, x2, y2);

        Assert.assertEquals(expected, result, 0.01);

        x1 = -1;
        y1 = -1;
        x2 = 1;
        y2 = 1;

        expected = 2.8;

        result = Point.distance(x1, y1, x2, y2);

        Assert.assertEquals(expected, result, 0.5);
    }
}
