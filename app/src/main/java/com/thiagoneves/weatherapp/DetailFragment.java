package com.thiagoneves.weatherapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.thiagoneves.weatherapp.databinding.FragmentDetailBinding;
import com.thiagoneves.weatherapp.model.CityWeather;


public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;

    public DetailFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDetailBinding.inflate(inflater, container, false);

        CityWeather cityWeather = DetailFragmentArgs.fromBundle(getArguments()).getCityWeather();
        binding.textView.setText(cityWeather.getTitle());

        return binding.getRoot();
    }
}