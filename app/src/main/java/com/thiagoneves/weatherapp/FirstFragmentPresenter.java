package com.thiagoneves.weatherapp;

import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;

import androidx.annotation.NonNull;

import com.thiagoneves.weatherapp.api.API;
import com.thiagoneves.weatherapp.api.WeatherService;
import com.thiagoneves.weatherapp.interfaces.FirstFragmentContract;

import com.thiagoneves.weatherapp.model.City;
import com.thiagoneves.weatherapp.model.CityEnum;
import com.thiagoneves.weatherapp.model.CityWeatherInfo;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragmentPresenter implements FirstFragmentContract.Presenter {
    private static final String TAG = "FirstFragmentPresenter";
    private WeatherService mWeatherService;
    private boolean mFirstLoad;

    @NonNull
    private final FirstFragmentContract.View mView;

    public FirstFragmentPresenter (@NonNull FirstFragmentContract.View view) {
        mView = view;
        mView.setPresenter(this);
        mWeatherService = API.getApi().create(WeatherService.class);
        mFirstLoad = true;
    }

    @Override
    public void subscribe() {
        loadData(false);
    }

    @Override
    public void unsubscribe() {
        //TODO to implement or delete it
    }

    public void loadData(boolean forceUpdate) {
        Log.d(TAG, "loadData: forceUpdate " + forceUpdate + " mFirstLoad " + mFirstLoad);
        loadData(forceUpdate || mFirstLoad, true);
        mFirstLoad = false;
    }

    //TODO use the enum instead of boolean as param
    public void loadData(boolean forceUpdate, boolean showLoading) {
        //TODO to implement showLoading on the view
        if (showLoading) {
            mView.showLoadingUI();
        }

        //TODO implement on the repository
        if (!forceUpdate) {
            return;
        }

        //TODO only for testing for now
        Call<List<CityWeatherInfo>> weatherByWoeidAndDate = mWeatherService.getWeatherByWoeidAndDate(CityEnum.MADRI.getWoeid(), DateUtil.getToday());
        Log.d(TAG, "loadData: cityWeather " + weatherByWoeidAndDate.request().url());

        weatherByWoeidAndDate.enqueue(new Callback<List<CityWeatherInfo>>() {
            @Override
            public void onResponse(@NonNull Call<List<CityWeatherInfo>> call, Response<List<CityWeatherInfo>> response) {
                if(response.code()==200) {
                    List<CityWeatherInfo> cityWeatherInfos = response.body();
                    if (cityWeatherInfos != null && !cityWeatherInfos.isEmpty()) {

                        City city = new City(CityEnum.MADRI); //TODO get from sharedPreferences
                        city.setCityWeatherInfos(cityWeatherInfos);
                        mView.showCityWeatherList(city);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<CityWeatherInfo>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onClick(CityWeatherInfo cityWeatherInfo) {
        mView.showDetailCityWeather(cityWeatherInfo);
    }
}
