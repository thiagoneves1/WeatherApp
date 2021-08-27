package com.thiagoneves.weatherapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//TODO only for testing for now
public class City implements Serializable {
    private CityEnum mCityEnum;
    private String title;

    public City(CityEnum cityEnum) {
        mCityEnum = cityEnum;
    }

    public String getTitle() {
        return mCityEnum.getTitleByWoeid(mCityEnum.getWoeid());
    }

    List<CityWeatherInfo> cityWeatherInfos = new ArrayList<>();

    public List<CityWeatherInfo> getCityWeatherInfos() {
        return cityWeatherInfos;
    }

    public void setCityWeatherInfos(List<CityWeatherInfo> cityWeatherInfos) {
        this.cityWeatherInfos = cityWeatherInfos;
    }
}
