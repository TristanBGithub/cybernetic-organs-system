package com.cybernetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Main compatibility checker class
public class CyberneticOrganCompatibility {
    private List<String> incompatibilityReasons;

    public CyberneticOrganCompatibility() {
        this.incompatibilityReasons = new ArrayList<>();
    }

    public boolean isCompatible(Patient patient,
                                CyberneticOrgan organ,
                                DiagnosticDecisionTree diagnosticTree) {

        incompatibilityReasons.clear();
        boolean isCompatible = true;

        //TODO:  Step 1: Get patient measurements and organ requirements

        //TODO: Step 2: Run diagnostic tree analysis

        //TODO: Step 3: Check each measurement against organ requirements

        return isCompatible;
    }

    public List<String> getIncompatibilityReasons() {
        return new ArrayList<>(incompatibilityReasons);
    }
}