/**
 * This class represents a cybernetic heart.
 */

package com.cybernetic;

import java.util.Random;

public class Heart extends CyberneticOrgan {
    private int pumpRate = 70;

    public Heart(String id, String model, String functionality, String compatibility) {
        super("ORG001", "CyberHeartX1", "Pumps blood", "Type O");
    }

    public int getPumpRate() {
        return pumpRate;
    }

    /**
     * Updates the pump rate according to the brain's control efficiency. The pump rate must stay between 40 and 100.
     * @param brain - the cybernetic brain being used to determine the new pump rate
     */
    public void updatePumpRate(Brain brain) {
        Random rnd = new Random();
        int randomFluctuation = rnd.nextInt(-4,4);
        int newPumpRate = pumpRate + (brain.getControlEfficiency() / 10) - 5 + randomFluctuation;
        if (newPumpRate >= 40 && newPumpRate <= 100)
            pumpRate = newPumpRate;
        else if (newPumpRate > 100)
            pumpRate = 100;
        else if (newPumpRate < 40)
            pumpRate = 40;
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
