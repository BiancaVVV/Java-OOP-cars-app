package com.epam.assessment.cars.domain;

public abstract class Car {
    private final String licensePlate;
    private final Model model;
    private int distanceDriven;

    public Car(String licensePlate, Model model) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.distanceDriven = 0;
    }

    public abstract void drive(int distance);

    public String getLicensePlate() {
        return licensePlate;
    }

    public Model getModel() {
        return model;
    }

    public int getDistanceDriven() {
        return distanceDriven;
    }

    protected void addDistance(int distance) {
        this.distanceDriven += distance;
    }
}
