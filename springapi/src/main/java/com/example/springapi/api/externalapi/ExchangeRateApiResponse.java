package com.example.springapi.api.externalapi;

import java.util.Map;

public class ExchangeRateApiResponse {
    private String result;
    private Map<String, Double> conversion_rates;

    // Getters and setters for the fields
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }

    public void setConversionRates(Map<String, Double> conversionRates) {
        this.conversion_rates = conversionRates;
    }
}
