package com.thiagoneves.weatherapp;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.thiagoneves.weatherapp.interfaces.DetailFragmentContract;
import com.thiagoneves.weatherapp.model.CityWeatherInfo;

public class DetailFragmentPresenter implements DetailFragmentContract.Presenter {
    private static final String TAG = "DetailFragmentPresenter";

    @NonNull
    private final DetailFragmentContract.View mView;

    public DetailFragmentPresenter(@NonNull DetailFragmentContract.View view) {
        mView = view;
        mView.setPresenter(this);

    }

    @Override
    public void subscribe() {}

    @Override
    public void unsubscribe() {}


    @Override
    public void loadDataFromSafeArgs(Bundle args) {
        CityWeatherInfo cityWeatherInfo = DetailFragmentArgs.fromBundle(args).getCityWeatherInfo();
        mView.showDetailCityWeather(cityWeatherInfo);
    }
}
