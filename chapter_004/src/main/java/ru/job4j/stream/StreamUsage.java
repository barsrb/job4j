package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    private final List<Task> tasks;

    public StreamUsage(List<Task> tasks) {
        this.tasks = tasks;
    }

    public long countSpent() {
        long spent = tasks.stream()
                .map(task -> task.spent)
                .reduce((sum, current) -> sum + current)
                .get();
        return spent;
    }

    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{"
                    + "name='" + name + '\''
                    + ", spent=" + spent + '}';
        }

        public String getName() {
            return name;
        }
    }

    public List<Task> getBugs() {
        List<Task> bugs = tasks.stream().filter(
                task -> task.name.contains("Bug")
        ).collect(Collectors.toList());
        bugs.forEach(System.out::println);
        return bugs;
    }

    public List<String> getTaskNames() {
        List<String> names = tasks.stream()
                .map(task -> task.name)
                .collect(Collectors.toList());
        return names;
    }
}