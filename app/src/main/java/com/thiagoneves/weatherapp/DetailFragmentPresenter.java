package com.thiagoneves.weatherapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.thiagoneves.weatherapp.interfaces.DetailFragmentContract;
import com.thiagoneves.weatherapp.model.CityWeatherInfoDay;

public class DetailFragmentPresenter implements DetailFragmentContract.Presenter {
    private static final String TAG = "DetailFragmentPresenter";

    @NonNull
    private final DetailFragmentContract.View mView;

    public DetailFragmentPresenter(@NonNull DetailFragmentContract.View view) {
        mView = view;
    }

    @Override
    public void subscribe(Context context) {}

    @Override
    public void unsubscribe() {}

    @Override
    public void loadDataFromSafeArgs(Context context, Bundle args) {
        CityWeatherInfoDay cityWeatherInfoDay = DetailFragmentArgs.fromBundle(args).getCityWeatherInfoDay();
        mView.showDetailCityWeather(context, cityWeatherInfoDay);
    }
}
