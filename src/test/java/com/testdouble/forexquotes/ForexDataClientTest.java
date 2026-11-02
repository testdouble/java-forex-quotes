package com.testdouble.forexquotes;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ForexDataClientTest {
    private final ForexDataClient client = new ForexDataClient("test-key");

    @Test
    void sameCurrencyRateIsOne() {
        assertEquals(Map.of("USD", 1.0), client.getRate("USD", "USD"));
    }

    @Test
    void sameCurrencyConversionReturnsTheAmount() {
        assertEquals(Map.of("USD", 250.0), client.convert("USD", "USD", 250));
    }

    @Test
    void rateKeyedByTargetCurrencyOrServiceDown() {
        try {
            Map<String, Double> rate = client.getRate("USD", "JPY");
            double jpy = rate.get("JPY");
            assertTrue(jpy >= 1.45 && jpy < 1.5, "rate was " + jpy);
        } catch (ExchangeServiceDownException e) {
            assertEquals("Exchange Service is offline.", e.getMessage());
        }
    }

    @Test
    void conversionMultipliesByTheRateOrServiceDown() {
        try {
            double jpy = client.convert("USD", "JPY", 100).get("JPY");
            assertTrue(jpy >= 145 && jpy < 150, "converted was " + jpy);
        } catch (ExchangeServiceDownException e) {
            assertEquals("Exchange Service is offline.", e.getMessage());
        }
    }
}
