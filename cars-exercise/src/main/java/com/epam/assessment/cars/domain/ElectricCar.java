package com.epam.assessment.cars.domain;

public class ElectricCar extends Car {
    private int batteryLevel; // kWh

    public ElectricCar(String licensePlate, ElectricModel model, int batteryLevel) {
        super(licensePlate, model);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void drive(int distance) {
        ElectricModel model = getElectricModel();

        // consum per km (float pentru precizie)
        double perKmConsumption = model.getEnergyConsumption() / 100.0;
        double totalConsumption = perKmConsumption * distance;

        int consumption = (int) Math.round(totalConsumption);

        if (batteryLevel - consumption < 0) {
            throw new IllegalArgumentException("Not enough charge to drive " + distance + " km");
        }

        batteryLevel -= consumption;
        addDistance(distance);

        System.out.println("Driving for " + distance + " km");
        System.out.println("    Odometer: " + getDistanceDriven() + " km");
        System.out.println("    Consumption: " + consumption + " kWh");
        System.out.println("    Battery level: " + batteryLevel + " kWh");
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public ElectricModel getElectricModel() {
        return (ElectricModel) getModel();
    }

    public int charge(int amount) {
        ElectricModel model = getElectricModel();
        batteryLevel = Math.min(model.getBatteryCapacity(), batteryLevel + amount);
        return batteryLevel;
    }
}
