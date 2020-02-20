package ru.job4j.oop.profession;

public class Surgeon extends Doctor {

    private Doctor anesthesiologist;

    public Surgeon(String name, String surname, String education, String birthday, boolean isIntern, Doctor anesthesiologist) {
        super(name, surname, education, birthday, isIntern);
        this.anesthesiologist = anesthesiologist;
    }

    public Surgeon(String name, String surname, String education, String birthday, boolean isIntern, Doctor curator, Doctor anesthesiologist) {
        super(name, surname, education, birthday, isIntern, curator);
        this.anesthesiologist = anesthesiologist;
    }

    public Doctor getAnesthesiologist() {
        return anesthesiologist;
    }
}
