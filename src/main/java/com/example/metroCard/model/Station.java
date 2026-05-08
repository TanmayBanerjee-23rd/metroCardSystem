package com.example.metroCard.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Station {
    CENTRAL, AIRPORT;

    private double totalCollection;
    private double totalDiscount;
    private Map<PassengerType, Integer> passengerCount;

    Station() {
        this.totalCollection = 0;
        this.totalDiscount = 0;
        this.passengerCount = new HashMap<>();
        for (PassengerType type : PassengerType.values()) {
            passengerCount.put(type, 0);
        }
    }

    public double getTotalCollection() {
        return totalCollection;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public Map<PassengerType, Integer> getPassengerCount() {
        return Collections.unmodifiableMap(passengerCount);
    }

    public void setTotalCollection(double totalCollection) {
        this.totalCollection = totalCollection;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public void setPassengerTypeCount(PassengerType type, int count) {
        this.passengerCount.put(type, count);
    }
}