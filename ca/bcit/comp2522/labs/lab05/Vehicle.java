package ca.bcit.comp2522.labs.lab05;

public abstract class Vehicle {
    String make;
    String model;
    int numPassengers;
    int topSpeed;

    public Vehicle() {
        this.make = "";
        this.model = "";
        this.numPassengers = 0;
        this.topSpeed = 0;
    }

    public Vehicle(String make, String model, int numPassengers, int topSpeed) {
        this.make = make;
        this.model = model;
        this.numPassengers = numPassengers;
        this.topSpeed = topSpeed;
    }

    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getNumPassengers() {
        return numPassengers;
    }
    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }
    public int getTopSpeed() {
        return topSpeed;
    }
    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    @Override
    public String toString() {
        return ("Make: " + make + " Model: " + model);
    }
}
