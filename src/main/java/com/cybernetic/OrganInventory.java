package com.cybernetic;

import java.util.ArrayList;

public class OrganInventory {
    private ArrayList<CyberneticOrgan> inventory;

    public OrganInventory() {
        inventory = new ArrayList<CyberneticOrgan>();
    }

    public String addOrgan(CyberneticOrgan organ) {
        inventory.add(organ);
        return "Organ added to inventory";
    }

    public CyberneticOrgan getOrgan (String model) {
        CyberneticOrgan dummy = new CyberneticOrgan("", "", "", "");
        return dummy;
    }
}
