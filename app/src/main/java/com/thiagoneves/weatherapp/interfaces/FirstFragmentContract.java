package com.thiagoneves.weatherapp.interfaces;

import com.thiagoneves.weatherapp.model.City;
import com.thiagoneves.weatherapp.model.CityWeatherInfoDay;

public interface FirstFragmentContract {

    interface View {

        void showLoadingUI();

        void showCityWeatherList(City city);

        void showDetailCityWeather(CityWeatherInfoDay cityWeatherInfoDay);

    }

    interface Presenter extends BasePresenter {

        void onClick(CityWeatherInfoDay cityWeatherInfoDay);

    }
}