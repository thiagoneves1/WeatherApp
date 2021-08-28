package com.thiagoneves.weatherapp.db.dbmodel;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WeatherInfoDayModel {

    @PrimaryKey(autoGenerate = true)
    public long weatherInfoId;

    public String applicableDate;

    public double minTemp;

    public double maxTemp;

    public double currentTemp;

    public String weatherStateName;

    public String humidity;

    public double windSpeed;

}