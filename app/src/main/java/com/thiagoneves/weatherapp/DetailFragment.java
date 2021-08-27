package com.thiagoneves.weatherapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.thiagoneves.weatherapp.databinding.FragmentDetailBinding;
import com.thiagoneves.weatherapp.interfaces.DetailFragmentContract;
import com.thiagoneves.weatherapp.model.CityWeatherInfo;


public class DetailFragment extends Fragment implements DetailFragmentContract.View {

    private FragmentDetailBinding binding;
    private DetailFragmentContract.Presenter mPresenter;

    public DetailFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDetailBinding.inflate(inflater, container, false);
        new DetailFragmentPresenter(this); //TODO put this on the Activity or remove the setPresenter
        mPresenter.loadDataFromSafeArgs(getArguments());

        return binding.getRoot();
    }

    @Override
    public void setPresenter(DetailFragmentContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showDetailCityWeather(CityWeatherInfo cityWeatherInfo) {
        binding.textView.setText(cityWeatherInfo.getHumidity());
    }
}