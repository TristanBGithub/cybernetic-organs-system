package com.cybernetic;

public class CyberneticOrgan {
    private String id;
    private String model;
    private String functionality;
    private String compatibility;

    public CyberneticOrgan(String id, String model, String functionality, String compatibility) {
        this.id = id;
        this.model = model;
        this.functionality = functionality;
        this.compatibility = compatibility;
    }

    public String getDetails() {
        return "ID: " + id + ", Model: " + model + ", Functionality: " + functionality + ", Compatibility: " + compatibility;
    }

    public String getModel() {
        return model;
    }

    public String getFunctionality() {
        return functionality;
    }

    public boolean isCompatible (String patientCompatibility) {
        return compatibility.equals(patientCompatibility);
    }
}
