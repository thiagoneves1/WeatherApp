package com.thiagoneves.weatherapp;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.thiagoneves.weatherapp.interfaces.FirstFragmentContract;
import com.thiagoneves.weatherapp.interfaces.RepositoryListener;
import com.thiagoneves.weatherapp.model.City;
import com.thiagoneves.weatherapp.model.CityWeatherInfoDay;
import com.thiagoneves.weatherapp.repository.WeatherRepository;

public class FirstFragmentPresenter implements FirstFragmentContract.Presenter {
    private static final String TAG = "FirstFragmentPresenter";

    private boolean mFirstLoad;

    private WeatherRepository mWeatherRepository;

    @NonNull
    private final FirstFragmentContract.View mView;

    public FirstFragmentPresenter (@NonNull FirstFragmentContract.View view, Context context) {
        mView = view;

        mFirstLoad = true;

        mWeatherRepository = new WeatherRepository(context);
    }

    @Override
    public void subscribe(Context context) {
        loadData(context, false);
    }

    @Override
    public void unsubscribe() {
        //TODO to implement
    }

    public void loadData(Context context, boolean forceUpdate) {
        Log.d(TAG, "loadData: forceUpdate " + forceUpdate + " mFirstLoad " + mFirstLoad);
        loadData(context, forceUpdate || mFirstLoad, true);
        mFirstLoad = false;
    }

    //TODO use the enum instead of boolean as param
    public void loadData(Context context, boolean forceUpdate, boolean showLoading) {
        //TODO to implement showLoading on the view
        if (showLoading) {
            mView.showLoadingUI();
        }

        //TODO implement on the repository
        if (!forceUpdate) {
            return;
        }

        mWeatherRepository.callInfoForTheDay(new RepositoryListener() {
            @Override
            public void loadedInfoForCity(City city) {
                mView.showCityWeatherList(city);
            }
        });
    }

    @Override
    public void onClick(CityWeatherInfoDay cityWeatherInfoDay) {
        mView.showDetailCityWeather(cityWeatherInfoDay);
    }
}
