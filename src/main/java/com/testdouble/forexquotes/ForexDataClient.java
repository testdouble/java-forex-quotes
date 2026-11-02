/*
  This library is provided without warranty under the MIT license
  Created by Dustin Tinney <dustin@testdouble.com>
*/
package com.testdouble.forexquotes;

import java.util.Map;

public class ForexDataClient {
    private final String apiKey;

    public ForexDataClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public Map<String, Double> getRate(String from, String to) {
        try {
            double rate = exchangeRate(to, from);
            return Map.of(to, rate);
        } catch (RuntimeException e) {
            throw new ExchangeServiceDownException("Exchange Service is offline.");
        }
    }

    public Map<String, Double> convert(String from, String to, double amount) {
        try {
            double total = amount * exchangeRate(to, from);
            return Map.of(to, total);
        } catch (RuntimeException e) {
            throw new ExchangeServiceDownException("Exchange Service is offline.");
        }
    }

    private double exchangeRate(String to, String from) {
        if (to.equals(from)) {
            return 1;
        }
        return ExchangeService.getRate(to, from);
    }
}
