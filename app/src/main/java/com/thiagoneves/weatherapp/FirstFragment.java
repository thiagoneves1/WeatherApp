package com.thiagoneves.weatherapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.thiagoneves.weatherapp.adapters.WeatherDayAdapter;
import com.thiagoneves.weatherapp.databinding.FragmentFirstBinding;
import com.thiagoneves.weatherapp.interfaces.FirstFragmentContract;
import com.thiagoneves.weatherapp.model.City;
import com.thiagoneves.weatherapp.model.CityWeatherInfoDay;
import com.thiagoneves.weatherapp.model.Weather;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements FirstFragmentContract.View {

    private FragmentFirstBinding binding;

    private FirstFragmentContract.Presenter mPresenter;
    private WeatherDayAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new FirstFragmentPresenter(this, getContext());

        List<Weather> weathers = new ArrayList<>();
        mAdapter = new WeatherDayAdapter(weathers, mPresenter);

        binding.recyclerview.setAdapter(mAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recyclerview.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void showDetailCityWeather(CityWeatherInfoDay cityWeatherInfoDay) {
        FirstFragmentDirections.ActionFirstFragmentToDetailFragment action = FirstFragmentDirections.actionFirstFragmentToDetailFragment(cityWeatherInfoDay);
        NavHostFragment.findNavController(FirstFragment.this)
                .navigate(action);
    }

    @Override
    public void showLoadingUI() {
        //TODO to implement
    }

    @Override
    public void showCityWeatherList(City city) {
        mAdapter.replaceData(city.getWeekWeathers());
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                binding.textViewTitle.setText(city.getTitle());
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(getContext());
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

}