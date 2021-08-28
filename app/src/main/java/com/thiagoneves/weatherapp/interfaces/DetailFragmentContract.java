package com.thiagoneves.weatherapp.interfaces;

import android.os.Bundle;

import com.thiagoneves.weatherapp.model.CityWeatherInfoDay;

public interface DetailFragmentContract {

    interface View {

        void showDetailCityWeather(CityWeatherInfoDay cityWeatherInfoDay);

    }

    interface Presenter extends BasePresenter {

        void loadDataFromSafeArgs(Bundle args);

    }
}