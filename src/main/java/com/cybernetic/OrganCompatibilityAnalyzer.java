package com.cybernetic;

import java.util.ArrayList;
import java.util.List;

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

    public int[][] createCompatibilityMatrix() {
        int[][] matrix = new int[organs.size()][patients.size() * 3]; // 3 factors: blood type, weight, HLA
        for (int i = 0; i < matrix.length; i++) {
            int patientNumber = 0;
            for (int j = 0; j < matrix[i].length; j += 3) {
                patientNumber++;
                matrix[i][j] = calculateBloodTypeCompatibility(organs.get(i).getBloodType(), patients.get(patientNumber - 1).getBloodType());
                matrix[i][j + 1] = calculateWeightCompatibility(organs.get(i).getWeight(), patients.get(patientNumber - 1).getWeight());
                matrix[i][j + 2] = calculateHlaCompatibility(organs.get(i).getHlaType(), patients.get(patientNumber - 1).getHlaType());
            }
        }

        return matrix;
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

    public double[][] calculateWeightedCompatibility(double[] weights) {
        int[][] compatibilityMatrix = createCompatibilityMatrix();
        double[][] resultMatrix = new double[organs.size()][patients.size()];
        for (int i = 0; i < compatibilityMatrix.length; i++) {
            int patientNumber = 0;
            for (int j = 2; j < compatibilityMatrix[i].length; j += 3) {
                patientNumber++;
                resultMatrix[i][patientNumber - 1] = weights[0] * compatibilityMatrix[i][j - 2] + weights[1] * compatibilityMatrix[i][j - 1] + weights[2] * compatibilityMatrix[i][j];
            }
        }

        return resultMatrix;
    }


    public void displayMatrix(int[][] matrix) {
        System.out.println("Initial Compatibility Matrix:");
        System.out.print("   ");
        for (int i = 0; i < patients.size(); i++)
            for (int j = 0; j < 3; j++)
                System.out.print(patients.get(i).getId() + " ");
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(organs.get(i).getName() + " ");
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    public void displayWeightMatrix(double[] weights) {
        System.out.println("\nWeight Matrix:");
        for (double weight : weights) {
            System.out.printf("%.2f  ", weight);
        }
        System.out.println();
    }

    public void displayWeightedMatrix(double[][] matrix) {
        System.out.println("\nFinal Weighted Compatibility Matrix:");
        System.out.print("   ");
        for (int i = 0; i < patients.size(); i++)
            System.out.print(patients.get(i).getId() + " ");
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(organs.get(i).getName() + " ");
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

}