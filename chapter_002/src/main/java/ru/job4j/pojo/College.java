package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("John");
        student.setSurname("Doe");
        student.setGroup(203);
        student.setEntranceDate(new Date());

        System.out.println("Student " + student.getName() + " " + student.getSurname() + " is in group " + student.getGroup());
    }
}
