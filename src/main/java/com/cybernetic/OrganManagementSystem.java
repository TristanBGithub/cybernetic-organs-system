package com.cybernetic;

import java.util.*;
import java.util.stream.Collectors;

public class OrganManagementSystem {
    private List<Organ> organs;
    private List<Patient> patients;

    public OrganManagementSystem(List<Organ> organs, List<Patient> patients) {
        this.organs = organs;
        this.patients = patients;
    }

    public Set<String> getUniqueBloodTypes() {
        Set<String> bloodTypes = new HashSet<>();
        for (Patient patient : patients)
            bloodTypes.add(patient.getBloodType());
        return bloodTypes;
    }

    public Map<String, List<Patient>> groupPatientsByBloodType() {
        return getUniqueBloodTypes().stream().collect(Collectors.toMap(b -> b,
                b -> patients.stream().filter(p -> p.getBloodType().equals(b)).collect(Collectors.toList())));
    }

    public List<Organ> sortOrgansByWeight() {
        List<Organ> sortedList = new ArrayList<>(organs);
        Collections.sort(sortedList, new organWeightComparator());
        return sortedList;
    }

    public List<Organ> getTopCompatibleOrgans(Patient patient, int n) {
        //TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static class organWeightComparator implements Comparator<Organ> {
        @Override
        public int compare(Organ o1, Organ o2) {
            return Integer.compare(o1.getWeight(), o2.getWeight());
        }
    }


}
