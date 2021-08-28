package com.thiagoneves.weatherapp.db.dbmodel;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class CityModel {

    @PrimaryKey(autoGenerate = true)
    public long cityId;

    public long date;

    @Ignore
    public List<WeatherModel> weatherModelList;


}