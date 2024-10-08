package com.cybernetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OrganManagementSystem {
    private List<Organ> organs;
    private List<Patient> patients;

    public OrganManagementSystem(List<Organ> organs, List<Patient> patients) {
        this.organs = organs;
        this.patients = patients;
    }

    public Set<String> getUniqueBloodTypes() {
        //TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Map<String, List<Patient>> groupPatientsByBloodType() {
        //TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<Organ> sortOrgansByWeight() {
        //TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<Organ> getTopCompatibleOrgans(Patient patient, int n) {
        //TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }




}
