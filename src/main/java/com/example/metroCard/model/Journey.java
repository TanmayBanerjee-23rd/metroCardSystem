package com.example.metroCard.model;

public class Journey {
    private final MetroCard card;
    private final PassengerType passengerType;
    private final Station fromStation;

    public Journey(MetroCard card, PassengerType passengerType, Station fromStation) {
        this.card = card;
        this.passengerType = passengerType;
        this.fromStation = fromStation;
    }

    public MetroCard getCard() {
        return card;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public Station getFromStation() {
        return fromStation;
    }
}