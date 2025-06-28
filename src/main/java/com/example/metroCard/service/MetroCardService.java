package com.example.metroCard.service;

import java.util.HashMap;
import java.util.Map;

import com.example.metroCard.model.MetroCard;

public class MetroCardService {
    private final Map<String, MetroCard> cards;

    public MetroCardService() {
        this.cards = new HashMap<>();
    }

    public void addCard(String cardNumber, double balance) {
        cards.put(cardNumber, new MetroCard(cardNumber, balance));
    }

    public MetroCard getCard(String cardNumber) {
        return cards.get(cardNumber);
    }
}