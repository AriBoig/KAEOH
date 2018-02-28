package com.example.arist.kaeoh;

/**
 * Created by arist on 28/02/2018.
 */

public class ESP {
    private String name;
    private String value;
    private String name_courant;
    private String unit;

    public ESP() {
    }

    public ESP(String name, String value, String name_courant, String unit) {
        this.name = name;
        this.value = value;
        this.name_courant = name_courant;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName_courant() {
        return name_courant;
    }

    public void setName_courant(String name_courant) {
        this.name_courant = name_courant;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
