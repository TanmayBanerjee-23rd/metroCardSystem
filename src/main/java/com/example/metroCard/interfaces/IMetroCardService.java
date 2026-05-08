package com.example.metroCard.interfaces;

import com.example.metroCard.model.MetroCard;

public interface IMetroCardService {

    public MetroCard getCard(String cardNumber);

    public void addCard(String cardNumber, double balance);

    public void addBalance(String cardNumber, double amount);

    public void deductCardBalance(String cardNumber, double amount);
}
