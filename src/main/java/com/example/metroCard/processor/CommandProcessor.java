package com.example.metroCard.processor;

import com.example.metroCard.interfaces.IJourneyService;
import com.example.metroCard.interfaces.IMetroCardService;
import com.example.metroCard.interfaces.ISummaryService;
import com.example.metroCard.model.Journey;
import com.example.metroCard.model.PassengerType;
import com.example.metroCard.model.Station;
import com.example.metroCard.service.JourneyService;
import com.example.metroCard.service.MetroCardService;
import com.example.metroCard.service.StationService;
import com.example.metroCard.service.SummaryService;

public class CommandProcessor {
    private final IMetroCardService cardService;
    private final IJourneyService journeyService;
    private final ISummaryService summaryService;

    public CommandProcessor() {
        this.cardService = new MetroCardService();
        StationService stationService = new StationService();
        this.journeyService = new JourneyService(stationService, cardService);
        this.summaryService = new SummaryService();
    }

    public void processCommand(String command) {
        String[] parts = command.split(" ");
        switch (parts[0]) {
            case "BALANCE":
                cardService.addCard(parts[1], Double.parseDouble(parts[2]));
                break;
            case "CHECK_IN":
                journeyService.processJourney(new Journey(
                        cardService.getCard(parts[1]),
                        PassengerType.valueOf(parts[2]),
                        Station.valueOf(parts[3])));
                break;
            case "PRINT_SUMMARY":
                summaryService.printSummary();
                break;
        }
    }
}