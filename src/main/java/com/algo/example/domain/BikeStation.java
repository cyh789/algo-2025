package com.algo.example.domain;

// BikeStation.java
public class BikeStation {
    private int id;
    private int bikeCount;

    public BikeStation(int id, int bikeCount) {
        this.id = id;
        this.bikeCount = bikeCount;
    }

    public int getId() { return id; }
    public int getBikeCount() { return bikeCount; }
    public void setBikeCount(int bikeCount) { this.bikeCount = bikeCount; }
}
