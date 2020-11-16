package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartUITestMockito {
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
        Input input = mock(Input.class);

        when(input.askInt(any(String.class), any(Integer.class))).thenReturn(0);

        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] {action});
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenSelectSecondAction() {
        Input input = mock(Input.class);

        when(input.askInt(any(String.class), any(Integer.class))).thenReturn(1);

        StubAction action1 = new StubAction();
        StubAction action2 = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] {action1, action2});
        assertThat(action1.isCall(), is(false));
        assertThat(action2.isCall(), is(true));
    }

    @Test
    public void whenSelectFirstAction() {
        Input input = mock(Input.class);

        when(input.askInt(any(String.class), any(Integer.class))).thenReturn(0);

        StubAction action1 = new StubAction();
        StubAction action2 = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] {action1, action2});
        assertThat(action1.isCall(), is(true));
        assertThat(action2.isCall(), is(false));
    }

    @Test
    public void whenPrtMenu() {
        Input input = mock(Input.class);

        when(input.askInt(any(String.class), any(Integer.class))).thenReturn(0);

        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] {action});
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whenEditItem() {

        Input input = mock(Input.class);
        EditAction editAction = new EditAction();

        StringJoiner expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator());
        expect.add("Item edit successful.");
        Tracker tracker = new Tracker();
        Item item = new Item("test 1");
        tracker.add(item);
        item = new Item("test 2");
        tracker.add(item);
        String editedID = item.getId();
        item = new Item("test 3");
        tracker.add(item);

        when(input.askStr(any(String.class))).thenReturn(editedID);
        editAction.execute(input, tracker);

        assertThat(new String(out.toByteArray()), is(expect.toString()));
        assertThat(tracker.findById(editedID).getName(), is(editedID));
    }


}