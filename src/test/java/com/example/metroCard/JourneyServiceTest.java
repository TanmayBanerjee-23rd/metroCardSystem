package com.example.metroCard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.metroCard.model.Journey;
import com.example.metroCard.model.MetroCard;
import com.example.metroCard.model.PassengerType;
import com.example.metroCard.model.Station;
import com.example.metroCard.service.JourneyService;
import com.example.metroCard.service.StationService;

import static org.junit.jupiter.api.Assertions.*;

class JourneyServiceTest {
    private JourneyService journeyService;
    private MetroCard card;

    @BeforeEach
    void setUp() {
        StationService stationService = new StationService();
        journeyService = new JourneyService(stationService);
        card = new MetroCard("MC1", 300.0);
    }

    @Test
    void testProcessJourneyWithSufficientBalance() {
        Journey journey = new Journey(card, PassengerType.ADULT, Station.CENTRAL);
        journeyService.processJourney(journey);
        assertEquals(100.0, card.getBalance());
        assertTrue(card.hasTraveledFromCentral());
    }

    @Test
    void testProcessJourneyWithInSufficientBalance() {
        Journey journey1 = new Journey(card, PassengerType.ADULT, Station.CENTRAL);
        journeyService.processJourney(journey1);
        Journey journey2 = new Journey(card, PassengerType.ADULT, Station.AIRPORT);
        journeyService.processJourney(journey2);
        Journey journey3 = new Journey(card, PassengerType.ADULT, Station.CENTRAL);
        journeyService.processJourney(journey3);
        assertEquals(0, card.getBalance());
        assertTrue(Station.CENTRAL.getTotalCollection() > 400);
    }

    @Test
    void testReturnJourneyDiscount() {
        Journey journey1 = new Journey(card, PassengerType.ADULT, Station.CENTRAL);
        journeyService.processJourney(journey1);
        Journey journey2 = new Journey(card, PassengerType.ADULT, Station.AIRPORT);
        journeyService.processJourney(journey2);
        assertEquals(0, card.getBalance());
    }
}