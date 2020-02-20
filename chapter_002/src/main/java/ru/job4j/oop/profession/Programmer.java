package ru.job4j.oop.profession;

public class Programmer extends Engineer {
    public String programmingLanguage;
    public Programmer(String name, String surname, String education, String birthday, int workExperience) {
        super(name, surname, education, birthday, workExperience);
    }

    public Programmer(String name, String surname, String education, String birthday, int workExperience, String programmingLanguage) {
        super(name, surname, education, birthday, workExperience);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
}
