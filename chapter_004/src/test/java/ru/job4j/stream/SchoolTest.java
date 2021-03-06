package ru.job4j.stream;

import org.junit.Test;
import ru.job4j.pojo.Student;

import java.util.*;

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

    private List<Student> studentsA = List.of(a1, a2, a3);
    private List<Student> studentsB = List.of(b1, b2);
    private List<Student> studentsC = List.of(c1, c2, c3);
    private List<Student> allStudents = List.of(a1, a2, a3, b1, b2, c1, c2, c3);


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
        Map<String, Student> expected = Map.of(
                a1.getSurname(), a1,
                a2.getSurname(), a2,
                a3.getSurname(), a3
        );
        assertThat(filtered, is(expected));
    }

    @Test
    public void testStudentsWithBoundMore50() {
        List<Student> allStudentsWithNull = Arrays.asList(a1, a2, null, a3, b2, null, b1, c1, null, null, c2, c3);

        List<Student> filtered = School.levelOf(allStudentsWithNull, 50);
        List<Student> expected = List.of(a3, a2, a1, b1, b2);
        assertThat(filtered, is(expected));
    }

}