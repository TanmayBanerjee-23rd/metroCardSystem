package com.example.metroCard;

import org.junit.jupiter.api.Test;

import com.example.metroCard.model.Station;
import com.example.metroCard.processor.CommandProcessor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class CommandProcessorTest {
    private CommandProcessor commandProcessor;

    @BeforeEach
    void setUp() {
        commandProcessor = new CommandProcessor();
    }

    @Test
    void testPrintSummary() {
        commandProcessor.processCommand("BALANCE MC1 600");
        commandProcessor.processCommand("CHECK_IN MC1 ADULT CENTRAL");
        commandProcessor.processCommand("PRINT_SUMMARY");

        assertTrue(Station.CENTRAL.getTotalCollection() > 0);
    }
}
