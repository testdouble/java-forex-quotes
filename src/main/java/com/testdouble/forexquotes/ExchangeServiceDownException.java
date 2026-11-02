package com.testdouble.forexquotes;

public class ExchangeServiceDownException extends RuntimeException {
    public ExchangeServiceDownException(String message) {
        super(message);
    }
}
