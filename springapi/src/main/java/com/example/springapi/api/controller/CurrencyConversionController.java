package com.example.springapi.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.springapi.api.model.CurrencyConversion;
import com.example.springapi.service.CurrencyConversionService;

@RestController
@RequestMapping("/api/currency-conversion")
public class CurrencyConversionController {
    private final CurrencyConversionService conversionService;

    public CurrencyConversionController(CurrencyConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping("/convert")
    public CurrencyConversion convertCurrency(
            @RequestParam("fromCurrency") String fromCurrency,
            @RequestParam("toCurrency") String toCurrency,
            @RequestParam("amount") double amount) {
        try {
            // Call the service to perform the conversion
            double convertedAmount = conversionService.convertCurrency(fromCurrency, toCurrency, amount);

            // Create a CurrencyConversion object to return
            CurrencyConversion conversion = new CurrencyConversion();
            conversion.setFromCurrency(fromCurrency);
            conversion.setToCurrency(toCurrency);
            conversion.setAmount(amount);
            conversion.setConvertedAmount(convertedAmount);

            return conversion;
        } catch (Exception e) {
            throw new CurrencyConversionException("Currency conversion failed: " + e.getMessage());
        }
    }

    // Custom exception class for currency conversion errors
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public static class CurrencyConversionException extends RuntimeException {
        public CurrencyConversionException(String message) {
            super(message);
        }
    }
}
