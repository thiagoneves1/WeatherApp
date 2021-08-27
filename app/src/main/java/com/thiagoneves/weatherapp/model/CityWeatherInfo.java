package com.thiagoneves.weatherapp.model;

import java.io.Serializable;

//TODO only for testing for now
public class CityWeatherInfo implements Serializable {


    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    private String humidity;

    public CityWeatherInfo() {
    }
}
