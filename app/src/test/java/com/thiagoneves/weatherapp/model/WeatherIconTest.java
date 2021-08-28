package com.thiagoneves.weatherapp.model;

import com.thiagoneves.weatherapp.R;

import junit.framework.TestCase;

public class WeatherIconTest extends TestCase {

    public void testTheIconOk() {
        WeatherIcon heavy_rain = WeatherIcon.getByApiName("Heavy Rain");
        assertNotNull(heavy_rain);
        assertEquals(heavy_rain.getDrawableId(), R.drawable.ic_heavy_rain);
    }

}