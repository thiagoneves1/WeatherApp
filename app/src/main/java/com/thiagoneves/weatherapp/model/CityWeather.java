package com.thiagoneves.weatherapp.model;

import java.io.Serializable;

//TODO only for testing for now
public class CityWeather implements Serializable {
    private String cityName;
    private String weekDay;

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }
}
