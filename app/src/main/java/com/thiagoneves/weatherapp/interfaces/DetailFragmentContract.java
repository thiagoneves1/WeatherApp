package com.thiagoneves.weatherapp.interfaces;

import android.content.Context;
import android.os.Bundle;

import com.thiagoneves.weatherapp.model.CityWeatherInfoDay;

public interface DetailFragmentContract {

    interface View {

        void showDetailCityWeather(Context context, CityWeatherInfoDay cityWeatherInfoDay);

    }

    interface Presenter extends BasePresenter {

        void loadDataFromSafeArgs(Context context, Bundle args);

    }
}