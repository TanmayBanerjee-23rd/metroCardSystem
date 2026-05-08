package com.example.metroCard.service;

import java.util.HashMap;
import java.util.Map;

import com.example.metroCard.interfaces.IMetroCardService;
import com.example.metroCard.model.MetroCard;

public class MetroCardService implements IMetroCardService {
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

    public void deductCardBalance(String cardNumber, double amount) {
        MetroCard card = cards.get(cardNumber);
        card.setBalance(card.getBalance() - amount);
    }

    public void addBalance(String cardNumber, double amount) {
        MetroCard card = cards.get(cardNumber);
        card.setBalance(card.getBalance() + amount);
    }
}