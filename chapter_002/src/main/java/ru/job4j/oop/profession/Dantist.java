package ru.job4j.oop.profession;

public class Dantist extends Doctor {
    private boolean isProsthetist;

    public Dantist(String name, String surname, String education, String birthday, boolean isIntern, boolean isProsthetist) {
        super(name, surname, education, birthday, isIntern);
        this.isProsthetist = isProsthetist;
    }

    public Dantist(String name, String surname, String education, String birthday, boolean isIntern, Doctor curator, boolean isProsthetist) {
        super(name, surname, education, birthday, isIntern, curator);
        this.isProsthetist = isProsthetist;
    }

    public boolean isProsthetist() {
        return isProsthetist;
    }
}
