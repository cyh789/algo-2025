package com.algo.example.strategy;

import com.algo.example.domain.BikeStation;
import com.algo.example.domain.Command;
import com.algo.example.domain.Truck;
import com.algo.example.service.StrategyService;

import java.util.*;

// SimpleRebalanceStrategy.java
public class SimpleRebalanceStrategy implements StrategyService {
    @Override
    public List<Map<String, Object>> decide(List<Truck> trucks, List<BikeStation> stations) {
        List<Map<String, Object>> commands = new ArrayList<>();
        for (Truck truck : trucks) {
            Map<String, Object> cmd = new HashMap<>();
            cmd.put("truck_id", truck.getId());
            cmd.put("command", Arrays.asList(Command.WAIT.getCode()));
            commands.add(cmd);
        }
        return commands;
    }
}
