/**
 * This class represents a cybernetic organ.
 */

package com.cybernetic;

public class CyberneticOrgan {
    private String name;
    private String model;
    private String functionality;
    private String compatibility;
    private int health = 100;

    public CyberneticOrgan(String name, String model, String functionality, String compatibility) {
        this.name = name;
        this.model = model;
        this.functionality = functionality;
        this.compatibility = compatibility;
    }

    public String getDetails() {
        return "Name: " + name + ", Model: " + model + ", Functionality: " + functionality + ", Compatibility: " + compatibility;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getFunctionality() {
        return functionality;
    }

    public String getCompatibility() {
        return compatibility;
    }

    public int getHealth() {
        return health;
    }

    /**
     * Updates the health of an organ given a new value for the health, ensuring that it stays between 0 and 100.
     * @param newHealth - the new health value
     */
    public void updateHealth(int newHealth) {
        if (newHealth >= 0 && newHealth <= 100)
            health = newHealth;
        else if (newHealth > 100)
            health = 100;
        else if (newHealth < 0)
            health = 0;
    }

    /**
     * Tests the compatibility between the organ and a patient
     * @param patientCompatibility - the patient's compatibility
     * @return true if compatible, false if not compatible
     */
    public boolean isCompatible (String patientCompatibility) {
        return compatibility.equals(patientCompatibility);
    }
}
