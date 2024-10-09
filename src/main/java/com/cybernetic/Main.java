package com.cybernetic;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Adding organs to inventory...");

        // Create an ArrayList for all organs, and populate it using the organ list csv
        ArrayList<CyberneticOrgan> allOrgans = new ArrayList<CyberneticOrgan>();

        File file = new File("sample-organ-list.csv");
        Scanner inFile = new Scanner(file);
        inFile.nextLine();
        String line;

        while (inFile.hasNext()) {
            line = inFile.nextLine();
            String[] tokens = line.split(",");
            CyberneticOrgan organ = new CyberneticOrgan(tokens[0], tokens[1], tokens [2], tokens[3]);
            allOrgans.add(organ);
        }
        inFile.close();

        // Fill the inventory with all organs
        OrganInventory organInventory = new OrganInventory();
        for (CyberneticOrgan organ : allOrgans)
            organInventory.addOrgan(organ);

        System.out.println("Sorting inventory by name, model, and compatibility...Using Collection.sort");
        long startTime = System.nanoTime();
        ArrayList<CyberneticOrgan> sortedOrgans = organInventory.sortOrganByNameModelAndCompatibilityUsingBuiltInSort();
        System.out.println("Time taken to sort using collection.sort: " + (System.nanoTime() - startTime) + "ns");

        System.out.println("Sorting inventory by name, model, and compatibility...Using QuickSort");
        startTime = System.nanoTime();
        organInventory.quickSortOrganByNameModelAndCompatibility(0, organInventory.getOrganList().size() - 1);
        System.out.println("Time taken to sort using quicksort: " + (System.nanoTime() - startTime) + "ns");

        // Write the sorted inventory to a csv file
        writeOrganInventory(organInventory.getOrganList());
        System.out.println("Sorted inventory written to file.");

    }
    private static void writeOrganInventory(ArrayList<CyberneticOrgan> sortedOrgans) {
        //write the sorted inventory to a new csv file
        String csvFile = "src/main/resources/sorted-organ-list.csv";
        try (PrintWriter writer = new PrintWriter(csvFile)) {
            writer.write("Model,Name,Functionality,Compatibility\n");
            for (CyberneticOrgan organ : sortedOrgans) {
                //write in this order name,model,functionality,compatibility
                writer.write(organ.getName() + "," + organ.getModel() + "," + organ.getFunctionality() + "," + organ.getCompatibility() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}