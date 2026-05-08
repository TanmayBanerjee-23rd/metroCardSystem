package com.example.metroCard.interfaces;

import com.example.metroCard.model.PassengerType;
import com.example.metroCard.model.Station;

public interface IStationService {

    public void updateStationStats(Station station, PassengerType passengerType, double fare, double serviceFee);

}
