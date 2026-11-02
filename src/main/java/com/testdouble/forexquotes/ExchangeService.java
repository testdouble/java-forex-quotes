package com.testdouble.forexquotes;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ExchangeService {
    public static boolean isValidCurrency(String currency) {
        return List.of("USD", "JPY").contains(currency);
    }

    public static double getRate(String to, String from) {
        // Note: This is set to mimic a 3rd party api that is making an external request
        ThreadLocalRandom random = ThreadLocalRandom.current();
        if (random.nextInt(20) == 1) {
            throw new RuntimeException("We're going down");
        }

        try {
            Thread.sleep(random.nextInt(3) * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return random.nextDouble(1.45, 1.5);
    }
}
