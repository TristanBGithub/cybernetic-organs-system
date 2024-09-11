package com.cybernetic;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
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

        CyberneticOrgan org001 = allOrgans.get(0);
        CyberneticOrgan org002 = allOrgans.get(1);
        CyberneticOrgan org003 = allOrgans.get(2);
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
        CyberneticOrgan org018 = allOrgans.get(17);
        CyberneticOrgan org019 = allOrgans.get(18);
        CyberneticOrgan org020 = allOrgans.get(19);

        OrganInventory organInventory = new OrganInventory();

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
            System.out.println("-" + organ.getModel());
    }
}