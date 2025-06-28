package com.example.metroCard.model;

public enum PassengerType {
    ADULT(200), SENIOR_CITIZEN(100), KID(50);

    private final double baseFare;

    PassengerType(double baseFare) {
        this.baseFare = baseFare;
    }

    public double getBaseFare() {
        return baseFare;
    }
}