package com.cybernetic;

import java.util.ArrayList;

public class OrganInventory {
    private ArrayList<CyberneticOrgan> inventory;

    public OrganInventory() {
        inventory = new ArrayList<CyberneticOrgan>();
    }

    public String addOrgan(CyberneticOrgan organ) {
        inventory.add(organ);
        return "Added " + organ.getModel() + " to inventory.";
    }

    public CyberneticOrgan getOrgan (String model) {
        CyberneticOrgan dummy = new CyberneticOrgan("", "", "", "");
        return dummy;
    }

    public ArrayList<CyberneticOrgan> getOrganList() {
        return inventory;
    }

    public String removeOrgan(String model) {
        boolean found = false;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getModel().equals(model)) {
                inventory.remove(i);
                found = true;
            }
        }
        if (found)
            return "Organ removed.";
        else
            return "Organ not found inventory.";
    }
    public ArrayList<CyberneticOrgan> searchOrganByFunctionality(String functionality) {
        ArrayList<CyberneticOrgan> hasFunctionality = new ArrayList<CyberneticOrgan>();
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getFunctionality().equals(functionality))
                hasFunctionality.add(inventory.get(i));
        }
        return hasFunctionality;
    }

    public ArrayList<CyberneticOrgan> sortOrgansByModel() {
        ArrayList<CyberneticOrgan> sortedList = new ArrayList<CyberneticOrgan>(inventory);
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = 0; j < sortedList.size() - i - 1; j++) {
                if(sortedList.get(j).getModel().compareToIgnoreCase(sortedList.get(j + 1).getModel()) > 1) {
                    CyberneticOrgan temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
        }
        return sortedList;
    }
}
