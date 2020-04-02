package ru.job4j.lambda;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GroupTest {

    @Test
    public void testSections() {
        List<Student> students = List.of(
                new Student("Student1", Set.of("A", "B")),
                new Student("Student2", Set.of("A")),
                new Student("Student3", Set.of("B", "C")),
                new Student("Student4", Set.of("A", "C"))
        );

        Map<String, Set<String>> sections = Group.sections(students);
        Map<String, Set<String>> expected = Map.of(
                "A", Set.of("Student1", "Student2", "Student4"),
                "B", Set.of("Student1", "Student3"),
                "C", Set.of("Student3", "Student4")
        );
        assertThat(sections, is(expected));
    }
}