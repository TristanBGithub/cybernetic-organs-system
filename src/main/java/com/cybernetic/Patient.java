package com.cybernetic;


import lombok.Data;

@Data
public class Patient {
    private String id;
    private String name;
    private String bloodType;
    private int weight;
    private String hlaType;

    public Patient(String id, String name,String bloodType, int weight, String hlaType) {
        this.id = id;
        this.name = name;
        this.bloodType = bloodType;
        this.weight = weight;
        this.hlaType = hlaType;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getBloodType() {
        return bloodType;
    }

    public int getWeight() {
        return weight;
    }

    public String getHlaType() {
        return hlaType;
    }
}
