package com.thiagoneves.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

//TODO only for testing for now
public class CityWeatherInfoDay implements Serializable {

    @SerializedName("applicable_date")
    public String applicableDate;

    @SerializedName("min_temp")
    private double minTemp;

    @SerializedName("max_temp")
    private double maxTemp;

    @SerializedName("the_temp")
    private double currentTemp;

    @SerializedName("weather_state_name")
    private String weatherStateName;

    private String humidity;

    @SerializedName("wind_speed")
    private String windSpeed;

    public CityWeatherInfoDay() {
    }

    public String getApplicableDate() {
        return applicableDate;
    }

    public void setApplicableDate(String applicableDate) {
        this.applicableDate = applicableDate;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(double currentTemp) {
        this.currentTemp = currentTemp;
    }

    public String getWeatherStateName() {
        return weatherStateName;
    }

    public void setWeatherStateName(String weatherStateName) {
        this.weatherStateName = weatherStateName;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }
}
