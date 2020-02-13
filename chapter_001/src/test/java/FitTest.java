import org.junit.Assert;
import org.junit.Test;
import ru.job4j.calculator.Fit;

public class FitTest {

    @Test
    public void manWeightTest() {
        int in = 180;
        double expected = 92.0;
        double out = Fit.manWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void womanWeightTest() {
        int in = 160;
        double expected = 57.5;
        double out = Fit.womanWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }
}
