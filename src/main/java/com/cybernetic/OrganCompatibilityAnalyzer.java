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
        //TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }


    public Map<Patient, List<Double>> calculateCompatibilityScores() {

        //TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    double calculateCompatibilityScore(Organ organ, Patient patient) {
        double bloodTypeScore = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType());
        double weightScore = calculateWeightCompatibility(organ.getWeight(), patient.getWeight());
        double hlaScore = calculateHlaCompatibility(organ.getHlaType(), patient.getHlaType());
        return (bloodTypeScore * 0.4) + (weightScore * 0.3) + (hlaScore * 0.3);
    }


    private int calculateBloodTypeCompatibility(String donorType, String recipientType) {
        //TODO: Calculate compatibility for each organ-patient pair based on compatibility calculation rules.
        return 0;
    }

    private int calculateWeightCompatibility(int organWeight, int patientWeight) {
       //TODO: Calculate compatibility for each organ-patient pair based on compatibility calculation rules.
        return 0;
    }

    private int calculateHlaCompatibility(String organHla, String patientHla) {
       //TODO: Calculate compatibility for each organ-patient pair based on compatibility calculation rules.
        return 0;
    }



}