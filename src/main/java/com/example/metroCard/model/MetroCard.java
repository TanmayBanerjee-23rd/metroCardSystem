package com.example.metroCard.model;

public class MetroCard {
    private final String cardNumber;
    private double balance;
    private boolean hasTraveledFromCentral;
    private boolean hasTraveledFromAirport;

    public MetroCard(String cardNumber, double balance) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.hasTraveledFromCentral = false;
        this.hasTraveledFromAirport = false;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deductBalance(double amount) {
        this.balance -= amount;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public boolean hasTraveledFromCentral() {
        return hasTraveledFromCentral;
    }

    public boolean hasTraveledFromAirport() {
        return hasTraveledFromAirport;
    }

    public void setHasTraveledFromCentral(boolean hasTraveled) {
        this.hasTraveledFromCentral = hasTraveled;
    }

    public void setHasTraveledFromAirport(boolean hasTraveled) {
        this.hasTraveledFromAirport = hasTraveled;
    }
}
