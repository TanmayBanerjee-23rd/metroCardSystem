package com.example.metroCard.service;

import com.example.metroCard.model.Journey;
import com.example.metroCard.model.MetroCard;
import com.example.metroCard.model.PassengerType;
import com.example.metroCard.model.Station;

public class JourneyService {
    private static final double SERVICE_FEE_PERCENTAGE = 0.02;
    private static final double RETURN_DISCOUNT = 0.5;

    private final StationService stationService;

    public JourneyService(StationService stationService) {
        this.stationService = stationService;
    }

    public void processJourney(Journey journey) {
        MetroCard card = journey.getCard();
        PassengerType passengerType = journey.getPassengerType();
        Station fromStation = journey.getFromStation();

        boolean isReturnJourney = (fromStation == Station.CENTRAL && card.hasTraveledFromAirport()) ||
                (fromStation == Station.AIRPORT && card.hasTraveledFromCentral());

        double fare = calculateFare(card, passengerType, fromStation, isReturnJourney);
        double serviceFee = 0;

        if (card.getBalance() < fare) {
            serviceFee = rechargeCard(card, fare);
        }

        card.deductBalance(fare + serviceFee);
        stationService.updateStationStats(fromStation, passengerType, fare, serviceFee);
        updateJourneyHistory(card, fromStation, isReturnJourney);
    }

    private double calculateFare(MetroCard card, PassengerType passengerType, Station fromStation,
            Boolean isReturnJourney) {
        double baseFare = passengerType.getBaseFare();

        return isReturnJourney ? (baseFare * RETURN_DISCOUNT) : baseFare;
    }

    private double rechargeCard(MetroCard card, double requiredFare) {
        double amountToRecharge = requiredFare - card.getBalance();
        double serviceFee = amountToRecharge * SERVICE_FEE_PERCENTAGE;

        card.addBalance(amountToRecharge + serviceFee);
        return serviceFee;
    }

    private void updateJourneyHistory(MetroCard card, Station fromStation, Boolean isReturnJourney) {
        if (isReturnJourney) {
            card.setHasTraveledFromAirport(false);
            card.setHasTraveledFromCentral(false);
        } else if (fromStation == Station.CENTRAL) {
            card.setHasTraveledFromCentral(true);
            card.setHasTraveledFromAirport(false);
        } else {
            card.setHasTraveledFromAirport(true);
            card.setHasTraveledFromCentral(false);
        }
    }
}