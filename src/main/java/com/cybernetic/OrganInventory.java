/**
 * This class represents an inventory of cybernetic organs.
 */

package com.cybernetic;

import java.util.*;

public class OrganInventory {
    private ArrayList<CyberneticOrgan> inventory;

    public OrganInventory() {
        inventory = new ArrayList<CyberneticOrgan>();
    }

    /**
     * Adds an organ to the inventory ArrayList and returns a confirmation message.
     * @param organ - the organ to be added
     * @return the confirmation message
     */
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

    /**
     * Removes an organ from the list given its model and returns a confirmation message.
     * @param model - the model of the organ to be removed
     * @return a message depending on whether the organ was removed successfully or not found
     */
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

    /**
     * Searches the inventory for organs given a functionality
     * @param functionality - the functionality to search for
     * @return the list of organs with the given functionality
     */
    public ArrayList<CyberneticOrgan> searchOrganByFunctionality(String functionality) {
        ArrayList<CyberneticOrgan> hasFunctionality = new ArrayList<CyberneticOrgan>();
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getFunctionality().equals(functionality))
                hasFunctionality.add(inventory.get(i));
        }
        return hasFunctionality;
    }

    /**
     * Sorts the inventory alphabetically by model
     * @return the sorted inventory list
     */
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

    public static class OrganComparator implements Comparator<CyberneticOrgan> {
        @Override
        public int compare(CyberneticOrgan o1, CyberneticOrgan o2) {
            int nameComparison = o1.getName().compareTo(o2.getName());
            if (nameComparison != 0)
                return nameComparison;

            int modelComparison = o1.getModel().compareTo(o2.getModel());
            if (modelComparison != 0)
                return modelComparison;

            return o1.getCompatibility().compareTo(o2.getCompatibility());
        }
    }

    public ArrayList<CyberneticOrgan> sortOrganByNameModelAndCompatibilityUsingBuiltInSort() {
        ArrayList<CyberneticOrgan> sortedList = new ArrayList<CyberneticOrgan>(inventory);
        Collections.sort(sortedList, new OrganComparator());

        return sortedList;
    }

    public void quickSortOrganByNameModelAndCompatibility(int low, int high) {
        if (low < high) {
            int partitionIndex = partition(inventory, low, high);

            quickSortOrganByNameModelAndCompatibility(low, partitionIndex - 1);
            quickSortOrganByNameModelAndCompatibility(partitionIndex + 1, high);
        }
    }

    private int partition(ArrayList<CyberneticOrgan> list, int low, int high) {
        CyberneticOrgan pivot = list.get(high);
        int i = low - 1;
        OrganComparator comparator = new OrganComparator();

        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), pivot) <= 0) {
                i++;
                CyberneticOrgan swapTemp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, swapTemp);
            }
        }

        CyberneticOrgan swapTemp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, swapTemp);

        return i + 1;
    }
}
