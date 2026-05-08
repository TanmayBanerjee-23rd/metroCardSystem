package com.example.metroCard.service;

import com.example.metroCard.interfaces.IStationService;
import com.example.metroCard.model.PassengerType;
import com.example.metroCard.model.Station;

public class StationService implements IStationService {
    public void updateStationStats(Station station, PassengerType passengerType, double fare, double serviceFee) {

        final double totalFare = fare + serviceFee;
        final double totalCollection = station.getTotalCollection() + totalFare;
        station.setTotalCollection(totalCollection);

        final double discount = isReturnJourney(fare, passengerType) ? (passengerType.getBaseFare() - fare) : 0;
        final double totalDiscount = station.getTotalDiscount() + discount;

        station.setTotalDiscount(totalDiscount);

        incrementPassengerTypeCount(station, passengerType);
    }

    private boolean isReturnJourney(double fare, PassengerType passengerType) {
        return fare < passengerType.getBaseFare();
    }

    private void incrementPassengerTypeCount(Station station, PassengerType passengerType) {
        station.setPassengerTypeCount(passengerType, station.getPassengerCount().get(passengerType) + 1);
    }
}