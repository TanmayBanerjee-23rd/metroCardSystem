package com.example.metroCard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.metroCard.model.MetroCard;
import com.example.metroCard.service.MetroCardService;

import static org.junit.jupiter.api.Assertions.*;

class MetroCardServiceTest {
    private MetroCardService cardService;

    @BeforeEach
    void setUp() {
        cardService = new MetroCardService();
    }

    @Test
    void testAddAndGetCard() {
        cardService.addCard("MC1", 100.0);
        MetroCard card = cardService.getCard("MC1");
        assertNotNull(card);
        assertEquals("MC1", card.getCardNumber());
        assertEquals(100.0, card.getBalance());
    }

    @Test
    void testGetNonExistentCard() {
        assertNull(cardService.getCard("MC2"));
    }
}