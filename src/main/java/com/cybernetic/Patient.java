/**
 * This class represents a patient.
 */

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

    /**
     * Adds an organ to the patient, returning a confirmation message
     * @param organ - the organ to be added
     * @return a message saying whether the organ was able to be added or not
     */
    public String addOrgan(CyberneticOrgan organ) {
        // If the final entry in the organ array is not null, then the array is full and the organ could not be added
        if (installedOrgans[4] != null)
            return "Unable to add organ";
        // Get the first null entry in the array and add the organ at that index
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

    /**
     * Returns the patient's organ array as an ArrayList
     * @return the organ ArrayList
     */
    public ArrayList<CyberneticOrgan> getOrganList() {
        return new ArrayList<CyberneticOrgan>(Arrays.asList(installedOrgans));
    }
}
