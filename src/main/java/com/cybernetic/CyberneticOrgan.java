package com.cybernetic;

import java.time.LocalDate;

public class CyberneticOrgan {
    private String id;
    private String type;
    private String model;
    private int powerLevel;
    private double compatibilityScore;
    private LocalDate manufactureDate;
    private String status;
    private String manufacturer;

    public CyberneticOrgan(String id, String type, String model, int powerLevel, double compatibilityScore, LocalDate manufactureDate, String status, String manufacturer) {
        this.id = id;
        this.type = type;
        this.model = model;
        this.powerLevel = powerLevel;
        this.compatibilityScore = compatibilityScore;
        this.manufactureDate = manufactureDate;
        this.status = status;
        this.manufacturer = manufacturer;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public double getCompatibilityScore() {
        return compatibilityScore;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }
}
