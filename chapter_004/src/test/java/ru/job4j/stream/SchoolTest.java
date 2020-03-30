package ru.job4j.stream;

import org.junit.Test;
import ru.job4j.pojo.Student;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {

    Student a1 = new Student(70);
    Student a2 = new Student(80);
    Student a3 = new Student(100);
    Student b1 = new Student(69);
    Student b2 = new Student(50);
    Student c1 = new Student(1);
    Student c2 = new Student(49);
    Student c3 = new Student(33);

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



}