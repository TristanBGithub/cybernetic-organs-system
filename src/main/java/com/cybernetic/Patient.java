package com.cybernetic;

import java.util.*;

public class Patient {
    private String name;
    private int age;
    private String medicalHistory;
    private CyberneticOrgan[] installedOrgans = new CyberneticOrgan[5];

    public Patient(String name, int age, String medicalHistory) {
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
    }

    public String addOrgan(CyberneticOrgan organ) {
        if (installedOrgans[4] != null)
            return "Unable to add organ";
        else {
            for (int i = 0; i < installedOrgans.length; i++) {
                if (installedOrgans[i] == null) {
                    installedOrgans[i] = organ;
                    break;
                }
            }
            return "Added " + organ.getModel() + " to " + name + "'s installed organs.";
        }
    }

    public String getPatientInfo() {
        return "Name: " + name + ", Age: " + age + ", Medical history: " + medicalHistory + ", Installed organs: " + Arrays.toString(installedOrgans);
    }

    public ArrayList<CyberneticOrgan> getOrganList() {
        return new ArrayList<CyberneticOrgan>(Arrays.asList(installedOrgans));
    }
}
