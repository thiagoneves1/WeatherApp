package com.thiagoneves.weatherapp;

import static com.thiagoneves.weatherapp.util.DateUtil.DAYS_OF_WEEK;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.thiagoneves.weatherapp.api.API;
import com.thiagoneves.weatherapp.api.WeatherService;
import com.thiagoneves.weatherapp.interfaces.FirstFragmentContract;

import com.thiagoneves.weatherapp.model.City;
import com.thiagoneves.weatherapp.model.CityEnum;
import com.thiagoneves.weatherapp.model.CityWeatherInfoDay;
import com.thiagoneves.weatherapp.model.Weather;
import com.thiagoneves.weatherapp.sharedpreferences.SharedPreferenceKeys;
import com.thiagoneves.weatherapp.sharedpreferences.SharedPreferenceUtil;
import com.thiagoneves.weatherapp.util.DateUtil;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragmentPresenter implements FirstFragmentContract.Presenter {
    private static final String TAG = "FirstFragmentPresenter";
    private WeatherService mWeatherService;
    private boolean mFirstLoad;
    private int mCurrentPosition;
    private List<String> mNextWeekDaysFromNow;

    @NonNull
    private final FirstFragmentContract.View mView;

    public FirstFragmentPresenter (@NonNull FirstFragmentContract.View view) {
        mView = view;
        mWeatherService = API.getApi().create(WeatherService.class);
        mFirstLoad = true;
        mCurrentPosition = 0;
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

        String cityName = SharedPreferenceUtil.getString(context, SharedPreferenceKeys.CURRENT_CITY, CityEnum.getDefault().name());
        CityEnum cityEnum = CityEnum.getByName(cityName);
        City city = new City(cityEnum);

        mNextWeekDaysFromNow = DateUtil.getNextWeekDaysFromNow();

        callInfoForTheDay(city, mNextWeekDaysFromNow.get(mCurrentPosition));
    }

    private void callInfoForTheDay(City city, String day) {
        Call<List<CityWeatherInfoDay>> weatherByWoeidAndDate = mWeatherService.getWeatherByWoeidAndDate(city.getWoeid(), day);

        Log.d(TAG, "loadData: cityWeather " + weatherByWoeidAndDate.request().url());

        weatherByWoeidAndDate.enqueue(new Callback<List<CityWeatherInfoDay>>() {
            @Override
            public void onResponse(@NonNull Call<List<CityWeatherInfoDay>> call, Response<List<CityWeatherInfoDay>> response) {
                if(response.code()==200) {
                    List<CityWeatherInfoDay> cityWeatherInfoDays = response.body();
                    if (cityWeatherInfoDays != null && !cityWeatherInfoDays.isEmpty()) {
                        Weather weather = new Weather(DateUtil.getToday());
                        weather.setCityWeatherInfos(cityWeatherInfoDays);
                        city.addWeekWeathers(Arrays.asList(weather));
                        mView.showCityWeatherList(city);
                        mCurrentPosition++;
                        if (mCurrentPosition < DAYS_OF_WEEK) {
                            callInfoForTheDay(city, mNextWeekDaysFromNow.get(mCurrentPosition));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<CityWeatherInfoDay>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onClick(CityWeatherInfoDay cityWeatherInfoDay) {
        mView.showDetailCityWeather(cityWeatherInfoDay);
    }
}
