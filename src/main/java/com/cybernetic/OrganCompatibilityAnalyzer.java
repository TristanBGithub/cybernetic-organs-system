package com.cybernetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrganCompatibilityAnalyzer {
    private List<Organ> organs;
    private List<Patient> patients;

    public OrganCompatibilityAnalyzer() {
        organs = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void addOrgan(Organ organ) {
        organs.add(organ);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }


    public List<Organ> getCompatibleOrgans(Patient patient) {
        return organs.stream().filter(o -> isCompatible(o, patient)).toList();
    }


    public Map<Patient, List<Double>> calculateCompatibilityScores() {
        return patients.stream().collect(Collectors.toMap(p -> p,
                p -> organs.stream().map(o -> calculateCompatibilityScore(o, p)).collect(Collectors.toList())));
    }

    double calculateCompatibilityScore(Organ organ, Patient patient) {
        double bloodTypeScore = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType());
        double weightScore = calculateWeightCompatibility(organ.getWeight(), patient.getWeight());
        double hlaScore = calculateHlaCompatibility(organ.getHlaType(), patient.getHlaType());
        return (bloodTypeScore * 0.4) + (weightScore * 0.3) + (hlaScore * 0.3);
    }


    private int calculateBloodTypeCompatibility(String donorType, String recipientType) {
        if (recipientType.equals(donorType))
            return 100;
        else
            switch (recipientType) {
                case "A+":
                    if (donorType.equals("A-") || donorType.equals("O+") || donorType.equals("O-"))
                        return 80;
                    else
                        return 0;
                case "A-", "B-", "O+":
                    if (donorType.equals("O-"))
                        return 80;
                    else return 0;
                case "B+":
                    if (donorType.equals("B-") || donorType.equals("O+") || donorType.equals("O-"))
                        return 80;
                    else
                        return 0;
                case "AB+":
                    return 80;
                case "AB-":
                    if (donorType.equals("A-") || donorType.equals("B-") || donorType.equals("O-"))
                        return 80;
                    else
                        return 0;
                default:
                    return 0;
            }
    }

    private int calculateWeightCompatibility(int organWeight, int patientWeight) {
        double ratio = (double)organWeight / (patientWeight * 1000);
        if (ratio >= 0.8 && ratio <= 1.2)
            return 100;
        else if (ratio >= 0.6 && ratio <= 1.4)
            return 50;
        else
            return 0;
    }

    private int calculateHlaCompatibility(String organHla, String patientHla) {
        String[] organTokens = organHla.split("-");
        String[] patientTokens = patientHla.split("-");

        int matchCount = 0;
        for (int i = 0; i < organTokens.length; i++) {
            if (organTokens[i].equals(patientTokens[i]))
                matchCount++;
        }

        return (int)(((double)matchCount / organTokens.length) * 100);
    }

    private boolean isCompatible(Organ organ, Patient patient) {
        if ((calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType()) > 0) && calculateWeightCompatibility(organ.getWeight(), patient.getWeight()) > 0)
            return true;
        else
            return false;
    }

}