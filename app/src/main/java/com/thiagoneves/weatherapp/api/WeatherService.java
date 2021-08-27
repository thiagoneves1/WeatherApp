package com.thiagoneves.weatherapp.api;

import com.thiagoneves.weatherapp.model.CityWeatherInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeatherService {
    @GET("{woeid}/{date}")
    Call<List<CityWeatherInfo>> getWeatherByWoeidAndDate(@Path(value = "woeid", encoded = true) int woeid, @Path(value = "date", encoded = true) String date);

}