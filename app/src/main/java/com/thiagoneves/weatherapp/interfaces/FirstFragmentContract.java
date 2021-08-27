package com.thiagoneves.weatherapp.interfaces;

import com.thiagoneves.weatherapp.model.City;
import com.thiagoneves.weatherapp.model.CityWeatherInfo;

public interface FirstFragmentContract {

    interface View extends BaseView<Presenter> {

        void showLoadingUI();

        void showCityWeatherList(City cityWeatherInfos);

        void showDetailCityWeather(CityWeatherInfo cityWeatherInfo);

    }

    interface Presenter extends BasePresenter {

        void onClick(CityWeatherInfo cityWeatherInfo);

    }
}