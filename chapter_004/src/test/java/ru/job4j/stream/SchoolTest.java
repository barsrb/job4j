package ru.job4j.stream;

import org.junit.Test;
import ru.job4j.pojo.Student;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {

    Student a1 = new Student("A1", 70);
    Student a2 = new Student("A2", 80);
    Student a3 = new Student("A3", 100);
    Student b1 = new Student("B1", 69);
    Student b2 = new Student("B2", 50);
    Student c1 = new Student("C1", 1);
    Student c2 = new Student("C2", 49);
    Student c3 = new Student("C3", 33);

    private List<Student> studentsA = Arrays.asList(a1, a2, a3);
    private List<Student> studentsB = Arrays.asList(b1, b2);
    private List<Student> studentsC = Arrays.asList(c1, c2, c3);
    private List<Student> allStudents = Arrays.asList(a1, a2, a3, b1, b2, c1, c2, c3);


    @Test
    public void testClassA() {
        List<Student> filtered = School.collect(allStudents, student -> student.getScore() >= 70 && student.getScore() <= 100);
        assertThat(filtered, is(studentsA));
    }

    @Test
    public void testClassB() {
        List<Student> filtered = School.collect(allStudents, student -> student.getScore() >= 50 && student.getScore() < 70);
        assertThat(filtered, is(studentsB));
    }

    @Test
    public void testClassC() {
        List<Student> filtered = School.collect(allStudents, student -> student.getScore() > 0 && student.getScore() < 50);
        assertThat(filtered, is(studentsC));
    }

    @Test
    public void testMappedAClass() {
        Map<String, Student> filtered = School.collectToMap(studentsA);
        Map<String, Student> expected = new HashMap<>();
        expected.put(a1.getSurname(), a1);
        expected.put(a2.getSurname(), a2);
        expected.put(a3.getSurname(), a3);
        assertThat(filtered, is(expected));
    }

}