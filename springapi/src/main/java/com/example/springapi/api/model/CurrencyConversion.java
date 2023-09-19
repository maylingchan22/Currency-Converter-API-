package com.example.springapi.api.model;

public class CurrencyConversion {
    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double convertedAmount;

    // Default no-argument constructor
    public CurrencyConversion() {
    }

    // Constructor with all fields
    public CurrencyConversion(String fromCurrency, String toCurrency, double amount, double convertedAmount) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
    }

    // Getters and setters
    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
}