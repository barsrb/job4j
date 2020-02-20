package ru.job4j.oop.profession;

public class Mechanic extends Engineer {
    private String vehicleType;

    public Mechanic(String name, String surname, String education, String birthday, int workExperience) {
        super(name, surname, education, birthday, workExperience);
    }

    public Mechanic(String name, String surname, String education, String birthday, int workExperience, String vehicleType) {
        super(name, surname, education, birthday, workExperience);
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}
