package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ItemSortTest {
    @Test
    public void sortItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item 1");
        Item item2 = new Item("item 2");
        Item item3 = new Item("item 3");
        Item item4 = new Item("item 4");
        tracker.add(item1);
        tracker.add(item3);
        tracker.add(item2);
        tracker.add(item4);
        List<Item> items = tracker.findAll();
        items.sort(new ItemSort());

        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item2);
        expected.add(item3);
        expected.add(item4);

        assertThat(items, is(expected));
    }

    @Test
    public void sortItemsReverse() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item 1");
        Item item2 = new Item("item 2");
        Item item3 = new Item("item 3");
        Item item4 = new Item("item 4");
        tracker.add(item1);
        tracker.add(item3);
        tracker.add(item2);
        tracker.add(item4);
        List<Item> items = tracker.findAll();
        items.sort(new ItemReverseSort());

        List<Item> expected = new ArrayList<>();
        expected.add(item4);
        expected.add(item3);
        expected.add(item2);
        expected.add(item1);

        assertThat(items, is(expected));
    }
}
