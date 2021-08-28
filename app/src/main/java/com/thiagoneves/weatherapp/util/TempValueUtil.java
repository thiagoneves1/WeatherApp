package com.thiagoneves.weatherapp.util;

public class TempValueUtil {
    public static String getFormatedValue(double value) {
        return String.format("%.2f", value);
    }
}
