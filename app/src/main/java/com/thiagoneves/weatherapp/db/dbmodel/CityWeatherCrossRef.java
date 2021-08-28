package com.thiagoneves.weatherapp.db.dbmodel;

import androidx.room.Entity;

@Entity(primaryKeys = {"weatherInfoId", "weatherId"})
public class CityWeatherCrossRef {

    public long weatherInfoId;

    public long weatherId;
}
