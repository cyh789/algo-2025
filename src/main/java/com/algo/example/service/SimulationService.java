package com.algo.example.service;

import com.algo.example.api.*;
import com.algo.example.domain.BikeStation;
import com.algo.example.domain.Truck;

import java.util.List;
import java.util.Map;

// SimulationService.java
public class SimulationService {
    private final StartApiClient startApi;
    private final LocationsApiClient locationsApi;
    private final TrucksApiClient trucksApi;
    private final SimulateApiClient simulateApi;
    private final ScoreApiClient scoreApi;

    public SimulationService(StartApiClient startApi,
                             LocationsApiClient locationsApi,
                             TrucksApiClient trucksApi,
                             SimulateApiClient simulateApi,
                             ScoreApiClient scoreApi) {
        this.startApi = startApi;
        this.locationsApi = locationsApi;
        this.trucksApi = trucksApi;
        this.simulateApi = simulateApi;
        this.scoreApi = scoreApi;
    }

    public void run(int problem, StrategyService strategy) {
        String authKey = startApi.start(problem);

        for (int t = 0; t < 720; t++) {
            List<BikeStation> stations = locationsApi.getLocations(authKey);
            List<Truck> trucks = trucksApi.getTrucks(authKey);

            List<Map<String, Object>> commands = strategy.decide(trucks, stations);
            simulateApi.simulate(authKey, commands);
        }

        double score = scoreApi.getScore(authKey);
        System.out.println("Final Score: " + score);
    }
}
