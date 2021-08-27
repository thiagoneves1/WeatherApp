package com.thiagoneves.weatherapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.thiagoneves.weatherapp.adapters.WeatherDayAdapter;
import com.thiagoneves.weatherapp.api.API;
import com.thiagoneves.weatherapp.api.WeatherService;
import com.thiagoneves.weatherapp.databinding.FragmentFirstBinding;
import com.thiagoneves.weatherapp.interfaces.ItemClickListener;
import com.thiagoneves.weatherapp.model.City;
import com.thiagoneves.weatherapp.model.CityWeather;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragment extends Fragment implements ItemClickListener {

    private static final String TAG = "FirstFragment";
    private FragmentFirstBinding binding;
    private CityWeather mCityWeather;
    private WeatherService mWeatherService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //TODO only for testing
        List<CityWeather> cityWeathers = new ArrayList<>();
        mCityWeather = new CityWeather();
        mCityWeather.setTitle("London");
        cityWeathers.add(mCityWeather);
        WeatherDayAdapter adapter = new WeatherDayAdapter(cityWeathers, this);

        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mWeatherService = API.getApi().create(WeatherService.class);
        loadData();
        binding.recyclerview.setLayoutManager(linearLayoutManager);

    }

    private void loadData() {
        Log.d(TAG, "loadData: ");

        //TODO only for testing for now
        Call<List<CityWeather>> weatherByWoeidAndDate = mWeatherService.getWeatherByWoeidAndDate(City.MADRI.getWoeid(), DateUtil.getToday());
        Log.d(TAG, "loadData: cityWeather " + weatherByWoeidAndDate.request().url());

        weatherByWoeidAndDate.enqueue(new Callback<List<CityWeather>>() {
            @Override
            public void onResponse(Call<List<CityWeather>> call, Response<List<CityWeather>> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if(response.code()==200){
                    //TODO add the result on the recyclerview
                    List<CityWeather> cityWeathers = response.body();
                    Log.d(TAG, "onResponse: humidity " + cityWeathers.get(0).getHumidity());
                }
            }

            @Override
            public void onFailure(Call<List<CityWeather>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view, int position) {
        FirstFragmentDirections.ActionFirstFragmentToDetailFragment action = FirstFragmentDirections.actionFirstFragmentToDetailFragment(mCityWeather);
        NavHostFragment.findNavController(FirstFragment.this)
                .navigate(action);
    }
}