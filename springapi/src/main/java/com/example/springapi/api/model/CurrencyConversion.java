package com.example.springapi.api.model;

import java.util.Map;

public class CurrencyConversion {
    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double convertedAmount;
    private Map<String, Double> exchangeRates;

    public CurrencyConversion() {
    }

    public CurrencyConversion(String fromCurrency, String toCurrency, double amount, double convertedAmount,
            Map<String, Double> exchangeRates) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
        this.exchangeRates = exchangeRates;
    }

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

    public Map<String, Double> getExchangeRates() {
        return exchangeRates;
    }

    public void setExchangeRates(Map<String, Double> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    @Override
    public String toString() {
        return "CurrencyConversion{" +
                "fromCurrency='" + fromCurrency + '\'' +
                ", toCurrency='" + toCurrency + '\'' +
                ", amount=" + amount +
                ", convertedAmount=" + convertedAmount +
                ", exchangeRates=" + exchangeRates +
                '}';
    }
}
