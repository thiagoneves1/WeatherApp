package com.thiagoneves.weatherapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.thiagoneves.weatherapp.databinding.FragmentSettingsBinding;
import com.thiagoneves.weatherapp.interfaces.SettingsFragmentContract;


public class SettingsFragment extends Fragment implements SettingsFragmentContract.View {
    private static final String TAG = "SettingsFragment";
    private FragmentSettingsBinding binding;
    private SettingsFragmentContract.Presenter mPresenter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSettingsBinding.inflate(inflater, container, false);

        mPresenter = new SettingsFragmentPresenter(this);//TODO use this one instead setPresent

        setListener();

        return binding.getRoot();

    }

    private void setListener() {
        binding.radioGroupCities.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mPresenter.setCheckedId(getContext(), checkedId);
            }
        });
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void setPresenter(SettingsFragmentContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showRadioValues(RadioButton radioButton, RadioGroup.LayoutParams params) {
        binding.radioGroupCities.addView(radioButton, params);
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