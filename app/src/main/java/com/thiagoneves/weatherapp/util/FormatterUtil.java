package com.thiagoneves.weatherapp.util;

public class FormatterUtil {
    public static String getFormattedValue(double value) {
        return String.format("%.0f", value); //TODO round the double before it
    }
}
