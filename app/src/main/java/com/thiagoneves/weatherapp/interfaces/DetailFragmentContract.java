package com.thiagoneves.weatherapp.interfaces;

import android.os.Bundle;

import com.thiagoneves.weatherapp.model.CityWeatherInfo;

public interface DetailFragmentContract {

    interface View extends BaseView<Presenter> {

        void showDetailCityWeather(CityWeatherInfo cityWeatherInfo);

    }

    interface Presenter extends BasePresenter {

        void loadDataFromSafeArgs(Bundle args);

    }
}