package com.cybernetic;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrganInventory {
    ArrayList<CyberneticOrgan> organs;
    int maxCapacity = 1000;

    public OrganInventory() {
        organs = new ArrayList<>(maxCapacity);
    }

    public void addOrgan(CyberneticOrgan organ) {
        if (!organ.getId().matches("ORG-\\d\\d\\d\\d"))
            throw new IllegalArgumentException("Organ ID is invalid.");
        else if (organ.getManufactureDate().isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Organ manufacture date is invalid.");
        else if (organ.getPowerLevel() <= 1 || organ.getPowerLevel() >= 100)
            throw new IllegalArgumentException("Organ power level is invalid.");
        else if (!(organ.getType().equals("HEART") || organ.getType().equals("LUNG") || organ.getType().equals("KIDNEY") || organ.getType().equals("LIVER")))
            throw new IllegalArgumentException("Organ type is invalid.");
        else if (organ.getCompatibilityScore() <= 0 || organ .getCompatibilityScore() >= 1.0)
            throw new IllegalArgumentException("Organ compatibility score is invalid.");
        else
            organs.add(organ);
    }

    public void removeOrgan(CyberneticOrgan organ, String removalReason) {
        organs.remove(organ);
    }

    public ArrayList<CyberneticOrgan> sortByPowerLevel() {
        ArrayList<CyberneticOrgan> sorted = new ArrayList<>(organs);
        quickSort(sorted, 0, sorted.size() - 1);
        return sorted;
    }

    private void quickSort(ArrayList<CyberneticOrgan> list, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(list, low, high);

            quickSort(list, low, partitionIndex - 1);
            quickSort(list, partitionIndex + 1, high);
        }
    }

    private int partition(ArrayList<CyberneticOrgan> list, int low, int high) {
        int pivot = list.get(high).getPowerLevel();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).getPowerLevel() >= pivot) {
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

    public ArrayList<CyberneticOrgan> sortByManufactureDate() {
        ArrayList<CyberneticOrgan> sorted = new ArrayList<>(organs);
        mergeSort(sorted, sorted.size());
        return sorted;
    }

    private static void mergeSort(ArrayList<CyberneticOrgan> list, int n) {
        if (n < 2)
            return;

        int mid = n / 2;
        ArrayList<CyberneticOrgan> l = new ArrayList<>(mid);
        ArrayList<CyberneticOrgan> r = new ArrayList<>(n - mid);

        for (int i = 0; i < mid; i++)
            l.add(i, list.get(i));

        for( int i = mid; i < n; i++)
            r.add(i - mid, list.get(i));

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(list, l, r, mid, n - mid);
    }

    private static void merge(ArrayList<CyberneticOrgan> list, ArrayList<CyberneticOrgan> l, ArrayList<CyberneticOrgan> r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l.get(i).getManufactureDate().isEqual(r.get(j).getManufactureDate()) || l.get(i).getManufactureDate().isBefore(r.get(j).getManufactureDate())) {
                list.set(k++, l.get(i++));
            }
            else
                list.set(k++, r.get(j++));
        }
        while (i < left)
            list.set(k++, l.get(i++));
        while (j < right)
            list.set(k++, r.get(j++));
    }

    public ArrayList<CyberneticOrgan> sortByCompatibilityScore() {
        ArrayList<CyberneticOrgan> sorted = new ArrayList<>(organs);
        bubbleSort(sorted);
        return sorted;
    }

    private void bubbleSort(ArrayList<CyberneticOrgan> list) {
        for (int i = 0; i < list.size(); i++)
            for (int j = 0; j < list.size() - i - 1; j++)
                if (list.get(j).getCompatibilityScore() < list.get(j + 1).getCompatibilityScore()) {
                    CyberneticOrgan temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
    }

}
