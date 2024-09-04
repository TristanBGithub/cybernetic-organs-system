package com.cybernetic;

import java.util.ArrayList;

public class Patient {
    private String name;
    private int age;
    private String medicalHistory;
    private ArrayList<CyberneticOrgan> installedOrgans;

    public Patient(String name, int age, String medicalHistory) {
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
        installedOrgans = new ArrayList<CyberneticOrgan>();
    }

    public String addOrgan(CyberneticOrgan organ) {
        installedOrgans.add(organ);
        return "Organ added to patient";
    }

    public String getPatientInfo() {
        return "Name: " + name + ", Age: " + age + ", Medical history: " + medicalHistory + ", Installed organs: " + installedOrgans.toString();
    }
}
