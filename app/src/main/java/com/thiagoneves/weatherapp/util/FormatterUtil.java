package com.thiagoneves.weatherapp.util;

public class FormatterUtil {
    public static String getFormattedValue(double value) {
        return String.format("%.2f", value);
    }
}
