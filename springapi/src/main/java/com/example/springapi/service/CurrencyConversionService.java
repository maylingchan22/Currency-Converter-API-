package com.example.springapi.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.springapi.api.externalapi.ExchangeRateApiResponse;
import com.example.springapi.api.model.CurrencyConversion;

@Service
public class CurrencyConversionService {

    @Value("${exchangerate.api.base-url}") // Configure this in your application.properties
    private String exchangeRateApiBaseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public CurrencyConversion convertCurrency(String from, String to, double amount) {
        String apiUrl = exchangeRateApiBaseUrl + "/latest/USD"; // Using USD as the base currency

        ExchangeRateApiResponse response = restTemplate.getForObject(apiUrl, ExchangeRateApiResponse.class);

        if (response == null || !"success".equals(response.getResult())) {
            // Handle the case where the response is null or the API request was not
            // successful
            return null;
        }

        Map<String, Double> rates = response.getConversionRates();

        if (rates == null || !rates.containsKey(to)) {
            // Handle the case where rates are null or do not contain the target currency
            // 'to'
            return null;
        }

        double conversionRate = rates.get(to);
        double convertedAmount = amount * conversionRate;

        CurrencyConversion currencyConversion = new CurrencyConversion();
        currencyConversion.setFromCurrency(from);
        currencyConversion.setToCurrency(to);
        currencyConversion.setAmount(amount);
        currencyConversion.setConvertedAmount(convertedAmount);

        return currencyConversion;
    }
}
