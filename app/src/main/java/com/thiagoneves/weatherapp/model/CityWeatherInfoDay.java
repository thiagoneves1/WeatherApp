package com.thiagoneves.weatherapp.model;

import android.content.Context;
import android.util.Log;

import com.google.gson.annotations.SerializedName;
import com.thiagoneves.weatherapp.util.DateUtil;
import com.thiagoneves.weatherapp.util.FormatterUtil;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;


public class CityWeatherInfoDay implements Serializable {

    public static final int DIFFERENCE_API_TO_ARRAY = 1;
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
    private double windSpeed;

    public CityWeatherInfoDay() {
    }

    public String getDayOfWeek(Context context) {
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(DateUtil.getFormatterAPI().parse(applicableDate));
            return DateUtil.getWeekDay(context, c.get(Calendar.DAY_OF_WEEK) - DIFFERENCE_API_TO_ARRAY);
        } catch (ParseException e) {
            Log.d("WP", "Exception " + e.getLocalizedMessage());
        }

        return "";
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

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
