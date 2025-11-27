package com.algo.example.domain;

// Truck.java
public class Truck {
    private int id;
    private int locationId;
    private int loadedBikes;

    public Truck(int id, int locationId, int loadedBikes) {
        this.id = id;
        this.locationId = locationId;
        this.loadedBikes = loadedBikes;
    }

    public int getId() { return id; }
    public int getLocationId() { return locationId; }
    public int getLoadedBikes() { return loadedBikes; }
}
