package com.example.metroCard.service;

import com.example.metroCard.model.Station;

public class SummaryService {
    public void printSummary() {
        for (Station station : Station.values()) {
            System.out.println("TOTAL_COLLECTION " + station + " " +
                    (int) station.getTotalCollection() + " " + (int) station.getTotalDiscount());
            System.out.println("PASSENGER_TYPE_SUMMARY");

            station.getPassengerCount().entrySet().stream()
                    .filter(entry -> entry.getValue() > 0)
                    .sorted((e1, e2) -> {
                        int countCompare = e2.getValue().compareTo(e1.getValue());
                        return countCompare != 0 ? countCompare : e1.getKey().name().compareTo(e2.getKey().name());
                    })
                    .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        }
    }
}