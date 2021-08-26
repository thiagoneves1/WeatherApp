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
import com.thiagoneves.weatherapp.interfaces.ItemClickListener;
import com.thiagoneves.weatherapp.model.CityWeather;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements ItemClickListener {

    private FragmentFirstBinding binding;
    CityWeather mCityWeather;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //TODO only for testing
        List<CityWeather> cityWeathers = new ArrayList<>();
        mCityWeather = new CityWeather();
        mCityWeather.setWeekDay("Monday");
        cityWeathers.add(mCityWeather);
        WeatherDayAdapter adapter = new WeatherDayAdapter(cityWeathers, this);

        binding.recyclerview.setAdapter(adapter);

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
    public void onClick(View view, int position) {
        FirstFragmentDirections.ActionFirstFragmentToDetailFragment action = FirstFragmentDirections.actionFirstFragmentToDetailFragment(mCityWeather);
        NavHostFragment.findNavController(FirstFragment.this)
                .navigate(action);
    }
}