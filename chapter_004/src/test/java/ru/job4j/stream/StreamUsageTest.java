package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StreamUsageTest {

    @Test
    public void getBugsTest() {
        StreamUsage.Task task1 = new StreamUsage.Task("Bug #1", 100);
        StreamUsage.Task task2 = new StreamUsage.Task("Task #2", 100);
        StreamUsage.Task task3 = new StreamUsage.Task("Bug #3", 100);
        StreamUsage su = new StreamUsage(Arrays.asList(task1, task2, task3));
        List<StreamUsage.Task> expected = Arrays.asList(task1, task3);
        List<StreamUsage.Task> bugs = su.getBugs();
        assertThat(expected, is(bugs));
    }


    @Test
    public void getTaskNamesTest() {
        StreamUsage.Task task1 = new StreamUsage.Task("Bug #1", 100);
        StreamUsage.Task task2 = new StreamUsage.Task("Task #2", 100);
        StreamUsage.Task task3 = new StreamUsage.Task("Bug #3", 100);
        StreamUsage su = new StreamUsage(Arrays.asList(task1, task2, task3));
        List<String> expected = Arrays.asList(task1.getName(), task2.getName(), task3.getName());
        List<String> names = su.getTaskNames();
        assertThat(expected, is(names));
    }

    @Test
    public void countSpentTest() {
        StreamUsage.Task task1 = new StreamUsage.Task("Bug #1", 100);
        StreamUsage.Task task2 = new StreamUsage.Task("Task #2", 10);
        StreamUsage.Task task3 = new StreamUsage.Task("Bug #3", 1000);
        StreamUsage su = new StreamUsage(Arrays.asList(task1, task2, task3));
        long expected = 1110L;
        long spentCount = su.countSpent();
        assertThat(expected, is(spentCount));
    }

}