package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }


    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] {action});
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenSelectSecondAction() {
        StubInput input = new StubInput(
                new String[] {"1"}
        );
        StubAction action1 = new StubAction();
        StubAction action2 = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] {action1, action2});
        assertThat(action1.isCall(), is(false));
        assertThat(action2.isCall(), is(true));
    }

    @Test
    public void whenSelectFirstAction() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action1 = new StubAction();
        StubAction action2 = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] {action1, action2});
        assertThat(action1.isCall(), is(true));
        assertThat(action2.isCall(), is(false));
    }

    @Test
    public void whenPrtMenu() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] {action});
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whenFindAll() {
        ShowAllAction act = new ShowAllAction();
        StringJoiner expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator());
        expect.add("Items in tracker - 3");
        Tracker tracker = new Tracker();
        Item item = new Item("test 1");
        tracker.add(item);
        expect.add("Item ID - " + item.getId() + ", name - " + item.getName());
        item = new Item("test 2");
        tracker.add(item);
        expect.add("Item ID - " + item.getId() + ", name - " + item.getName());
        item = new Item("test 3");
        tracker.add(item);
        expect.add("Item ID - " + item.getId() + ", name - " + item.getName());
        act.execute(new StubInput(new String[] {}), tracker);
        assertThat(new String(out.toByteArray()), is(expect.toString()));
    }

    @Test
    public void whenFindByName() {
        FindByNameAction act = new FindByNameAction();
        StringJoiner expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator());
        expect.add("Founded items - 2");
        Tracker tracker = new Tracker();
        Item item = new Item("test 1");
        tracker.add(item);
        item = new Item("test 2");
        tracker.add(item);
        item = new Item("test 3");
        tracker.add(item);
        item = new Item("test name");
        tracker.add(item);
        expect.add("Item ID - " + item.getId() + ", name - " + item.getName());
        item = new Item("test name");
        tracker.add(item);
        expect.add("Item ID - " + item.getId() + ", name - " + item.getName());
        act.execute(new StubInput(new String[] {"test name"}), tracker);
        assertThat(new String(out.toByteArray()), is(expect.toString()));
    }
}