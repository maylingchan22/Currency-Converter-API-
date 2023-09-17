package com.example.springapi.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyConversionUtil {
    // Round a double value to a specified number of decimal places.

    public static double round(double value, int decimalPlaces) {
        if (decimalPlaces < 0) {
            throw new IllegalArgumentException("Decimal places must be non-negative");
        }

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(decimalPlaces, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
