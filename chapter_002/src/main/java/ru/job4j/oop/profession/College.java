package ru.job4j.oop.profession;

import ru.job4j.oop.Freshman;
import ru.job4j.oop.Student;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        System.out.println(freshman);
        Student student = freshman;
        System.out.println(student);
        Object object = student;
        System.out.println(object);
    }
}
