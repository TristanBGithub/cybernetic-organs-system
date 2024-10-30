package com.cybernetic;

public class OrganCompatibilityAnalyzer {

    public Patient findCompatiblePatient(Organ organ, WaitingList waitingList) {
        WaitingListNode currentNode = waitingList.getHead();
        while (currentNode != null) {
            if (isCompatible(organ, currentNode.patient)) {
                return currentNode.patient;
            }
            currentNode = currentNode.next;
        }

        return null;
    }


    private boolean isCompatible(Organ organ, Patient patient) {
        int bloodTypeScore = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType());
        int weightScore = calculateWeightCompatibility(organ.getWeight(), patient.getWeight());
        int hlaScore = calculateHlaCompatibility(organ.getHlaType(), patient.getHlaType());
        return bloodTypeScore > 0 && weightScore > 0 && hlaScore > 0;
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

}