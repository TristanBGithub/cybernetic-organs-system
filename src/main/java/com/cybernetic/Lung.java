/**
 * This class represents a cybernetic lung.
 */

package com.cybernetic;

import java.util.Random;

public class Lung extends CyberneticOrgan {
    private int oxygenLevel = 95;

    public Lung(String id, String model, String functionality, String compatibility) {
        super("ORG003", "CyberLungZ3", "Filters air", "Type B");
    }

    public int getOxygenLevel() {
        return oxygenLevel;
    }

    /**
     * Updates the oxygen level according to the heart's pump rate. The oxygen level must stay between 70 and 100.
     * @param heart - the cybernetic heart being used to determine the new oxygen level
     */
    public void updateOxygenLevel(Heart heart) {
        Random rnd = new Random();
        int randomFluctuation = rnd.nextInt(-2,2);
        int newOxygenLevel = oxygenLevel + (heart.getPumpRate() / 20) - 3 + randomFluctuation;
        if (newOxygenLevel >= 70 && newOxygenLevel <= 100)
            oxygenLevel = newOxygenLevel;
        else if (newOxygenLevel > 100)
            oxygenLevel = 100;
        else if (newOxygenLevel < 0)
            oxygenLevel = 0;
    }

    /**
     * Updates the health according to the heart's pump rate.
     * @param heart - the cybernetic heart being used to determine the new health
     */
    public void updateHealth(Heart heart) {
        int newHealth = getHealth() - 1 + (heart.getPumpRate() / 25) - 2;
        updateHealth(newHealth);
    }
}
