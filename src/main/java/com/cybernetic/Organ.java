package com.cybernetic;
import lombok.Data;

@Data
class Organ {
    private String id;  // New property
    private String name;
    private String bloodType;
    private int weight;
    private String hlaType;

    public Organ(String id, String name, String bloodType, int weight, String hlaType) {
        this.id = id;
        this.name = name;
        this.bloodType = bloodType;
        this.weight = weight;
        this.hlaType = hlaType;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getHlaType() {
        return hlaType;
    }

    public int getWeight() {
        return weight;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
