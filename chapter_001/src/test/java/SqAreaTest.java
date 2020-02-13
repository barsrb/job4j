import org.junit.Assert;
import org.junit.Test;
import ru.job4j.condition.SqArea;

public class SqAreaTest {
    @Test
    public void sqAreaTest() {
        double result = SqArea.square(4, 1);
        double expected = 1.0;
        Assert.assertEquals(expected, result, 0.1);

        result = SqArea.square(6, 2);
        expected = 2.0;
        Assert.assertEquals(expected, result, 0.5);
    }
}
