package com.thiagoneves.weatherapp.repository;

import static com.thiagoneves.weatherapp.util.DateUtil.DAYS_OF_WEEK;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.thiagoneves.weatherapp.api.API;
import com.thiagoneves.weatherapp.api.WeatherService;
import com.thiagoneves.weatherapp.interfaces.RepositoryListener;
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

public class WeatherRepository {
    private static final String TAG = "WeatherRepository";
    private int mCurrentPosition;
    private List<String> mNextWeekDaysFromNow;
    private WeatherService mWeatherService;
    private City mCity;

    public WeatherRepository(Context context) {
        mNextWeekDaysFromNow = DateUtil.getNextWeekDaysFromNow();
        String cityName = SharedPreferenceUtil.getString(context, SharedPreferenceKeys.CURRENT_CITY, CityEnum.getDefault().name());
        CityEnum cityEnum = CityEnum.getByName(cityName);
        mCity = new City(cityEnum);
        mWeatherService = API.getApi().create(WeatherService.class);
        mCurrentPosition = 0;
    }

    //TODO and save the data in the room database as cache,
    // and reuse it when valid, and clear the data from DB when we don't need of this anymore.
    // When we will load, check if we already has the day in database, and get from there when we have
    public void callInfoForTheDay(RepositoryListener listener) {

        Call<List<CityWeatherInfoDay>> weatherByWoeidAndDate = mWeatherService.getWeatherByWoeidAndDate(mCity.getWoeid(), mNextWeekDaysFromNow.get(mCurrentPosition));

        Log.d(TAG, "loadData: cityWeather " + weatherByWoeidAndDate.request().url());

        weatherByWoeidAndDate.enqueue(new Callback<List<CityWeatherInfoDay>>() {
            @Override
            public void onResponse(@NonNull Call<List<CityWeatherInfoDay>> call, Response<List<CityWeatherInfoDay>> response) {
                if(response.code()==200) {
                    List<CityWeatherInfoDay> cityWeatherInfoDays = response.body();
                    if (cityWeatherInfoDays != null && !cityWeatherInfoDays.isEmpty()) {
                        Weather weather = new Weather(DateUtil.getToday());
                        weather.setCityWeatherInfos(cityWeatherInfoDays);
                        mCity.addWeekWeathers(Arrays.asList(weather));
                        listener.loadedInfoForCity(mCity);
                        mCurrentPosition++;
                        if (mCurrentPosition < DAYS_OF_WEEK) {
                            callInfoForTheDay(listener);
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
}
