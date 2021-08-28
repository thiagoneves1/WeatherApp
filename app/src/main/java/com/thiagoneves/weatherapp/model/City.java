package com.thiagoneves.weatherapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//TODO only for testing for now
public class City implements Serializable {
    private CityEnum mCityEnum; //TODO remove enum, it's fixed only for development
    private String title;

    public List<Weather> getWeekWeathers() {
        return weekWeathers;
    }

    public void setWeekWeathers(List<Weather> weekWeathers) {
        this.weekWeathers = weekWeathers;
    }

    List<Weather> weekWeathers = new ArrayList<>();

    public City(CityEnum cityEnum) {
        mCityEnum = cityEnum;
    }

    public int getWoeid() {
        return mCityEnum.getWoeid();
    }

    public String getTitle() {
        return mCityEnum.getTitle();
    }


}
