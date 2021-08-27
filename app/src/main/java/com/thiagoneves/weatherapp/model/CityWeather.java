package com.thiagoneves.weatherapp.model;

import java.io.Serializable;

//TODO only for testing for now
public class CityWeather implements Serializable {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    private String humidity;

    public CityWeather() {
    }
}
