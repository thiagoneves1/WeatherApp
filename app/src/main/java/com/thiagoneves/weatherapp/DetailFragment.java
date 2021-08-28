package com.thiagoneves.weatherapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.thiagoneves.weatherapp.databinding.DetailContainerBinding;
import com.thiagoneves.weatherapp.databinding.FragmentDetailBinding;
import com.thiagoneves.weatherapp.interfaces.DetailFragmentContract;
import com.thiagoneves.weatherapp.model.CityWeatherInfoDay;
import com.thiagoneves.weatherapp.model.WeatherIcon;
import com.thiagoneves.weatherapp.util.TempValueUtil;


public class DetailFragment extends Fragment implements DetailFragmentContract.View {

    private FragmentDetailBinding mBinding;
    private DetailContainerBinding mDetailContainerBinding;
    private DetailFragmentContract.Presenter mPresenter;

    public DetailFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = FragmentDetailBinding.inflate(inflater, container, false);
        mDetailContainerBinding = DetailContainerBinding.bind(mBinding.getRoot());
        mPresenter = new DetailFragmentPresenter(this);
        mPresenter.loadDataFromSafeArgs(getArguments());

        return mBinding.getRoot();
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.clear();
    }

    @Override
    public void showDetailCityWeather(CityWeatherInfoDay cityWeatherInfoDay) {
        mDetailContainerBinding.textViewDay.setText(cityWeatherInfoDay.getWeatherStateName());
        mDetailContainerBinding.textViewDay.setText(cityWeatherInfoDay.getApplicableDate());
        mDetailContainerBinding.textMin.setText(TempValueUtil.getFormatedValue(cityWeatherInfoDay.getMinTemp()));
        mDetailContainerBinding.textMax.setText(TempValueUtil.getFormatedValue(cityWeatherInfoDay.getMaxTemp()));
        mDetailContainerBinding.textCurrent.setText(TempValueUtil.getFormatedValue(cityWeatherInfoDay.getCurrentTemp()));
        mDetailContainerBinding.textWeatherName.setText(cityWeatherInfoDay.getWeatherStateName());
        WeatherIcon weatherIcon = WeatherIcon.getByApiName(cityWeatherInfoDay.getWeatherStateName());
        mDetailContainerBinding.imageIconWeather.setBackground(ContextCompat.getDrawable(getContext(), weatherIcon.getDrawableId()));
        mDetailContainerBinding.textHumidityValue.setText(cityWeatherInfoDay.getHumidity());
        mDetailContainerBinding.textWindspeedValue.setText(getString(R.string.windspeed_fromat, TempValueUtil.getFormatedValue(cityWeatherInfoDay.getWindSpeed())));
    }
}