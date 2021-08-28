package com.thiagoneves.weatherapp.db.dbmodel;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class WeatherModel {

    @PrimaryKey(autoGenerate = true)
    public long weatherId;

    @Ignore
    public List<WeatherInfoDayModel> weatherInfoDayModelList;

}