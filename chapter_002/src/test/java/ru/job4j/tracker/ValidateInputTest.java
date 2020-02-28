package ru.job4j.tracker;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        String[] data = {"one", "1"};
        ValidateInput input = new ValidateStubInput(data);
        input.askInt("Enter");
        String expect = "Please enter validate data again.\r\n";
        assertThat(mem.toString(), is(expect));
        System.setOut(out);
    }

    @Test
    public void whenLessThenMinInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        String[] data = {"-5", "1"};
        ValidateInput input = new ValidateStubInput(data);
        input.askInt("Enter", 4);
        String expect = "Please select key from menu.\r\n";
        assertThat(mem.toString(), is(expect));
        System.setOut(out);
    }

    @Test
    public void whenMoreThenMaxInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        String[] data = {"5", "1"};
        ValidateInput input = new ValidateStubInput(data);
        input.askInt("Enter", 4);
        String expect = "Please select key from menu.\r\n";
        assertThat(mem.toString(), is(expect));
        System.setOut(out);
    }
}