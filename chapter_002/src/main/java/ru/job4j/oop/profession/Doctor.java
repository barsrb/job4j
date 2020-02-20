package ru.job4j.oop.profession;

public class Doctor extends Profession {

    private boolean isIntern;

    private Doctor curator;

    public Doctor(String name, String surname, String education, String birthday, boolean isIntern) {
        super(name, surname, education, birthday);
        this.isIntern = isIntern;
    }

    public Doctor(String name, String surname, String education, String birthday, boolean isIntern, Doctor curator) {
        super(name, surname, education, birthday);
        this.isIntern = isIntern;
        this.curator = curator;
    }

    public boolean isIntern() {
        return isIntern;
    }

    public Doctor getCurator() {
        return curator;
    }
}
