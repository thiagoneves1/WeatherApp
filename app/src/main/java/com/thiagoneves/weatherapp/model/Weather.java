package com.thiagoneves.weatherapp.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Weather implements Serializable {

    private String mDate;

    List<CityWeatherInfoDay> cityWeatherInfoDays = new ArrayList<>();

    public Weather(String date) {
        this.mDate = date;
    }

    public List<CityWeatherInfoDay> getCityWeatherInfos() {
        return cityWeatherInfoDays;
    }

    public void setCityWeatherInfos(List<CityWeatherInfoDay> cityWeatherInfoDays) {
        this.cityWeatherInfoDays = cityWeatherInfoDays;
    }

}