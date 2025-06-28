package com.example.metroCard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.metroCard.model.PassengerType;
import com.example.metroCard.model.Station;
import com.example.metroCard.service.StationService;

import static org.junit.jupiter.api.Assertions.*;

class StationServiceTest {
    private StationService stationService;

    @BeforeEach
    void setUp() {
        stationService = new StationService();
    }

    @Test
    void testUpdateStationStats() {
        stationService.updateStationStats(Station.CENTRAL, PassengerType.ADULT, 200.0, 4.0);
        assertTrue(Station.CENTRAL.getTotalCollection() > 0);
        assertTrue(Station.CENTRAL.getPassengerCount().get(PassengerType.ADULT).longValue() > 0L);
    }

    @Test
    void testUpdateStationStatsWithDiscount() {
        stationService.updateStationStats(Station.AIRPORT, PassengerType.SENIOR_CITIZEN, 50.0, 0.0);
        assertTrue(Station.AIRPORT.getTotalCollection() > 0);
        assertTrue(Station.AIRPORT.getTotalDiscount() > 0);
        assertTrue(Station.AIRPORT.getPassengerCount().get(PassengerType.SENIOR_CITIZEN).longValue() > 0L);
    }
}