package com.example.springapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.springapi.api.model.CurrencyConversion;

import java.util.Map;

@Service
public class CurrencyConversionService {
    @Value("${exchange.api.baseurl}")
    private String apiUrl;

    @Value("${exchange.api.accesskey}")
    private String accessKey;

    private final RestTemplate restTemplate;

    public CurrencyConversionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        String endpoint = "latest";
        String requestUrl = apiUrl + endpoint + "?access_key=" + accessKey;

        // Make a GET request to the API
        ExchangeRatesResponse response = restTemplate.getForObject(requestUrl, ExchangeRatesResponse.class);

        if (response != null && response.getRates() != null) {
            double fromRate = response.getRates().get(fromCurrency);
            double toRate = response.getRates().get(toCurrency);

            if (fromRate != 0 && toRate != 0) {
                // Perform the conversion
                double convertedAmount = (amount / fromRate) * toRate;
                return convertedAmount;
            }
        }

        throw new CurrencyConversionException(
                "Unsupported currency conversion: " + fromCurrency + " to " + toCurrency);
    }

    public static class CurrencyConversionException extends RuntimeException {
        public CurrencyConversionException(String message) {
            super(message);
        }
    }
}
