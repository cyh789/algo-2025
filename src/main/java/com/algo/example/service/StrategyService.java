package com.algo.example.service;

import com.algo.example.domain.BikeStation;
import com.algo.example.domain.Truck;

import java.util.List;
import java.util.Map;

// StrategyService.java
public interface StrategyService {
    List<Map<String, Object>> decide(List<Truck> trucks, List<BikeStation> stations);
}
