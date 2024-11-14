package com.cybernetic;

import java.time.LocalDate;

public class Patient {
    private String id;
    private String name;
    private int age;
    private String bloodType;
    private String organNeeded;
    private int urgencyLevel;
    private LocalDate registrationDate;
    private String status;

    public Patient(String id, String name, int age, String bloodType, String organNeeded, int urgencyLevel, LocalDate registrationDate, String status) {
        if (!id.matches("PAT-\\d\\d\\d\\d"))
            throw new IllegalArgumentException("Patient ID is invalid.");
        else if (age <= 0 || age >= 120)
            throw new IllegalArgumentException("Patient age is invalid.");
        else if (!(bloodType.equals("A+") || bloodType.equals("A-") || bloodType.equals("B+") || bloodType.equals("B-") || bloodType.equals("AB+") || bloodType.equals("AB-") || bloodType.equals("O+") || bloodType.equals("O-")))
            throw new IllegalArgumentException("Patient blood type is invalid.");
        else if (urgencyLevel < 1 || urgencyLevel > 10)
            throw new IllegalArgumentException("Patient urgency level is invalid.");
        else if (!(organNeeded.equals("HEART") || organNeeded.equals("LUNG") || organNeeded.equals("KIDNEY") || organNeeded.equals("LIVER")))
            throw new IllegalArgumentException("Patient organ needed is invalid.");
        else if (!status.equals("WAITING"))
            throw new IllegalArgumentException("Patient status is invalid.");

        this.id = id;
        this.name = name;
        this.age = age;
        this.bloodType = bloodType;
        this.organNeeded = organNeeded;
        this.urgencyLevel = urgencyLevel;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getOrganNeeded() {
        return organNeeded;
    }
}
