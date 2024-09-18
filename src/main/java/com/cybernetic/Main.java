package com.cybernetic;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
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

        // Create new organ objects using the allOrgans list
        Heart org001 = new Heart(allOrgans.get(0).getId(), allOrgans.get(0).getModel(), allOrgans.get(0).getFunctionality(), allOrgans.get(0).getCompatibility());
        CyberneticOrgan org002 = allOrgans.get(1);
        Lung org003 = new Lung(allOrgans.get(2).getId(), allOrgans.get(2).getModel(), allOrgans.get(2).getFunctionality(), allOrgans.get(2).getCompatibility());
        CyberneticOrgan org004 = allOrgans.get(3);
        CyberneticOrgan org005 = allOrgans.get(4);
        CyberneticOrgan org006 = allOrgans.get(5);
        CyberneticOrgan org007 = allOrgans.get(6);
        CyberneticOrgan org008 = allOrgans.get(7);
        CyberneticOrgan org009 = allOrgans.get(8);
        CyberneticOrgan org010 = allOrgans.get(9);
        CyberneticOrgan org011 = allOrgans.get(10);
        CyberneticOrgan org012 = allOrgans.get(11);
        CyberneticOrgan org013 = allOrgans.get(12);
        CyberneticOrgan org014 = allOrgans.get(13);
        CyberneticOrgan org015 = allOrgans.get(14);
        CyberneticOrgan org016 = allOrgans.get(15);
        CyberneticOrgan org017 = allOrgans.get(16);
        Brain org018 = new Brain(allOrgans.get(17).getId(), allOrgans.get(17).getModel(), allOrgans.get(17).getFunctionality(), allOrgans.get(17).getCompatibility());
        CyberneticOrgan org019 = allOrgans.get(18);
        CyberneticOrgan org020 = allOrgans.get(19);

/*        OrganInventory organInventory = new OrganInventory();

        System.out.println("Adding organs to inventory...");
        System.out.println(organInventory.addOrgan(org001));
        System.out.println(organInventory.addOrgan(org002));
        System.out.println();

        Patient johnDoe = new Patient("John Doe", 30, "dummy");
        System.out.println("Adding organs to patient John Doe...");
        System.out.println(johnDoe.addOrgan(org001));
        System.out.println();

        System.out.println("Listing organs installed for John Doe...");
        ArrayList<CyberneticOrgan> johnDoeList = johnDoe.getOrganList();
        int organCount = 0;
        while (johnDoeList.get(organCount) != null)
            organCount++;
        for (int i = 0; i < organCount; i++)
            System.out.println("-" + johnDoeList.get(i).getModel() + ": " + johnDoeList.get(i).getFunctionality());
        System.out.println();

        System.out.println("Searching for organs with functionality 'Enhanced vision'...");
        ArrayList<CyberneticOrgan> searchResults = organInventory.searchOrganByFunctionality("Enhanced vision");
        System.out.println("Found " + searchResults.size() + " organ(s):");
        for (CyberneticOrgan organ : searchResults)
            System.out.println("-" + organ.getModel() + ": " + organ.getFunctionality());
        System.out.println();

        System.out.println("Sorting organs by model name in inventory...");
        ArrayList<CyberneticOrgan> sortedOrgans = organInventory.sortOrgansByModel();
        System.out.println("Sorted organs:");
        for (CyberneticOrgan organ: sortedOrgans)
            System.out.println("-" + organ.getModel());*/

        healthSimulation(org001, org003, org018, 1);
    }

    /**
     * This method simulates the health of a heart, brain, and lung over time.
     * @param heart - the cybernetic heart
     * @param lung - the cybernetic lung
     * @param brain - the cybernetic brain
     * @param time - the starting time
     */
    public static void healthSimulation(Heart heart, Lung lung, Brain brain, int time) {
        Random rnd = new Random();
        int eventChance;
        int randomOrgan;
        int randomHealthChange;

        // Print the results of the simulation if any organ's health is zero or time is 100
        if (heart.getHealth() == 0 || lung.getHealth() == 0 || brain.getHealth() == 0 || time == 100) {
            System.out.println("Simulation Ended\n" +
                    "Time: " + time + "\n" +
                    "Heart health: " + heart.getHealth() + "\n" +
                    "Lung health: " + lung.getHealth() + "\n" +
                    "Brain health: " + lung.getHealth());
            if (time == 100 && heart.getHealth() > 0 && lung.getHealth() > 0 && brain.getHealth() > 0)
                System.out.println("Simulation result: Success");
            else
                System.out.println("Simulation result: Failure");
        }
        else {

            // Update the values for each organ
            heart.updatePumpRate(brain);
            heart.updateHealth(lung);
            lung.updateOxygenLevel(heart);
            lung.updateHealth(heart);
            brain.updateControlEfficiency(lung);
            brain.updateHealth(lung);

            // There is a 1 in 10 chance of a random event happening, which will select an organ at random and change its health by a random amount between -10 and 10
            eventChance = rnd.nextInt(10);
            if (eventChance == 0) {
                randomOrgan = rnd.nextInt(3);
                randomHealthChange = rnd.nextInt(-10, 11);

                System.out.print("EVENT at time " + time + ": Random health change for ");
                if (randomOrgan == 0) {
                    heart.updateHealth(heart.getHealth() + randomHealthChange);
                    System.out.println("heart by " + randomHealthChange + "%");
                }
                else if (randomOrgan == 1) {
                    lung.updateHealth(lung.getHealth() + randomHealthChange);
                    System.out.println("lung by " + randomHealthChange + "%");
                }
                else if (randomOrgan == 2) {
                    brain.updateHealth(brain.getHealth() + randomHealthChange);
                    System.out.println("brain by " + randomHealthChange + "%");
                }
            }

            // Print the current status of the organs
            System.out.println("Time: " + time + "\n" +
                    "Heart Health: " + heart.getHealth() + " | Pump Rate: " + heart.getPumpRate() + "\n" +
                    "Lung Health: " + lung.getHealth() + " | Oxygen Level: " + lung.getOxygenLevel() + "\n" +
                    "Brain Health: " + brain.getHealth() + " | Control Efficiency: " + brain.getControlEfficiency() + "\n");

            // Print alerts if an organ's health falls below the critical threshold
            if (heart.getHealth() <= 25)
                System.out.println("ALERT at time " + time + ": Heart critical! Health at " + heart.getHealth() + "%");
            if (lung.getHealth() <= 25)
                System.out.println("ALERT at time " + time + ": Lung critical! Health at " + lung.getHealth() + "%");
            if (brain.getHealth() <= 25)
                System.out.println("ALERT at time " + time + ": Brain critical! Health at " + brain.getHealth() + "%");

            time++;
            healthSimulation(heart, lung, brain, time);
        }
    }
}