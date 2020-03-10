package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void sortJobsAscByName() {
        Job job1 = new Job("First", 2);
        Job job2 = new Job("Second", 1);
        Comparator<Job> comparator = new JobAscByName();
        int compareResult = comparator.compare(job1, job2);
        assertThat(compareResult, lessThan(0));
    }

    @Test
    public void sortJobsDescByName() {
        Job job1 = new Job("First", 2);
        Job job2 = new Job("Second", 1);
        Comparator<Job> comparator = new JobDescByName();
        int compareResult = comparator.compare(job1, job2);
        assertThat(compareResult, greaterThan(0));
    }

    @Test
    public void sortJobsAscByPriority() {
        Job job1 = new Job("First", 2);
        Job job2 = new Job("Second", 1);
        Comparator<Job> comparator = new JobAscByPriority();
        int compareResult = comparator.compare(job1, job2);
        assertThat(compareResult, greaterThan(0));
    }

    @Test
    public void sortJobsDescByPriority() {
        Job job1 = new Job("First", 2);
        Job job2 = new Job("Second", 1);
        Comparator<Job> comparator = new JobDescByPriority();
        int compareResult = comparator.compare(job1, job2);
        assertThat(compareResult, lessThan(0));
    }

    @Test
    public void sortJobsAscByNameThenDescPriority() {
        Job job1 = new Job("First", 2);
        Job job2 = new Job("Second", 1);
        Job job3 = new Job("Second", 5);
        List<Job> jobs = new ArrayList<>();
        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);
        Comparator<Job> comparator = new JobAscByName().thenComparing(new JobDescByPriority());
        jobs.sort(comparator);
        List<Job> expected = new ArrayList<>();
        expected.add(job1);
        expected.add(job3);
        expected.add(job2);
        assertThat(jobs, is(expected));
    }

    @Test
    public void sortJobsAscByPriorityThenDescByName() {
        Job job1 = new Job("First", 2);
        Job job2 = new Job("Second", 1);
        Job job3 = new Job("Second", 2);
        List<Job> jobs = new ArrayList<>();
        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);
        Comparator<Job> comparator = new JobAscByPriority().thenComparing(new JobDescByName());
        jobs.sort(comparator);
        List<Job> expected = new ArrayList<>();
        expected.add(job2);
        expected.add(job3);
        expected.add(job1);
        assertThat(jobs, is(expected));
    }


}