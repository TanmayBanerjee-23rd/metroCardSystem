package com.example.metroCard.service;

import com.example.metroCard.model.PassengerType;
import com.example.metroCard.model.Station;

public class StationService {
    public void updateStationStats(Station station, PassengerType passengerType, double fare, double serviceFee) {
        station.addCollection(fare + serviceFee);
        station.addDiscount(passengerType.getBaseFare() * 0.5 * (isReturnJourney(fare, passengerType) ? 1 : 0));
        station.incrementPassengerCount(passengerType);
    }

    private boolean isReturnJourney(double fare, PassengerType passengerType) {
        return fare < passengerType.getBaseFare();
    }
}