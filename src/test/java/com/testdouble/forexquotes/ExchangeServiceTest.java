package com.testdouble.forexquotes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExchangeServiceTest {
    @Test
    void knowsUsdAndJpy() {
        assertTrue(ExchangeService.isValidCurrency("USD"));
        assertTrue(ExchangeService.isValidCurrency("JPY"));
        assertFalse(ExchangeService.isValidCurrency("EUR"));
    }
}
