package com.thiagoneves.weatherapp.db.dbmodel;

import androidx.room.Entity;

@Entity(primaryKeys = {"cityId", "weatherId"})
public class WeatherAndInfoDayCrossRef {

    public long cityId;

    public long weatherId;
}
