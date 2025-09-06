package com.epam.assessment.cars.domain;


import java.util.Objects;

public class Model implements Comparable<Model> {
    private final String manufacturer;
    private final String modelName;
    private final int power;

    public Model(String manufacturer, String modelName, int power) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.power = power;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public int getPower() {
        return power;
    }

    @Override
    public int compareTo(Model other) {
        int cmp = this.manufacturer.compareTo(other.manufacturer);
        if (cmp == 0) {
            cmp = this.modelName.compareTo(other.modelName);
        }
        return cmp;
    }

    @Override
    public String toString() {
        return "Model{" +
                "manufacturer='" + manufacturer + '\'' +
                ", modelName='" + modelName + '\'' +
                ", power=" + power +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Model)) return false;
        Model model = (Model) o;
        return power == model.power &&
                manufacturer.equals(model.manufacturer) &&
                modelName.equals(model.modelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, modelName, power);
    }
}

