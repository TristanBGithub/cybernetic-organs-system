/**
 * This class represents a cybernetic brain.
 */

package com.cybernetic;

import java.util.Random;

public class Brain extends CyberneticOrgan {
    private int controlEfficiency = 90;

    public Brain(String id, String model, String functionality, String compatibility) {
        super("ORG018", "CyberBrainZ2", "Memory boost", "Type AB");
    }

    public int getControlEfficiency() {
        return controlEfficiency;
    }

    /**
     * Updates the control efficiency according to the lung's oxygen level. Control efficiency must stay between 50 and 100.
     * @param lung - the cybernetic lung being used to determine the new oxygen level
     */
    public void updateControlEfficiency(Lung lung) {
        Random rnd = new Random();
        int randomFluctuation = rnd.nextInt(-2,2);
        int newControlEfficiency = controlEfficiency + (lung.getOxygenLevel() / 20) - 3 + randomFluctuation;
        if (newControlEfficiency >= 50 && newControlEfficiency <= 100)
            controlEfficiency = newControlEfficiency;
        else if (newControlEfficiency > 100)
            controlEfficiency = 100;
        else if (newControlEfficiency < 50)
            controlEfficiency = 50;
    }

    /**
     * Updates the health according to the lung's oxygen level.
     * @param lung - the cybernetic lung being used to determine the new health
     */
    public void updateHealth(Lung lung) {
        int newHealth = getHealth() - 1 + (lung.getOxygenLevel() / 25) - 2;
        updateHealth(newHealth);
    }
}
