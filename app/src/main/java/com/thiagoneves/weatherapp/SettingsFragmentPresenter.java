package com.thiagoneves.weatherapp;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.thiagoneves.weatherapp.interfaces.SettingsFragmentContract;
import com.thiagoneves.weatherapp.model.CityEnum;
import com.thiagoneves.weatherapp.sharedpreferences.SharedPreferenceKeys;
import com.thiagoneves.weatherapp.sharedpreferences.SharedPreferenceUtil;
import com.thiagoneves.weatherapp.util.ViewUtil;

public class SettingsFragmentPresenter implements SettingsFragmentContract.Presenter {
    private static final String TAG = "SettingsFragmentPres";

    @NonNull
    private final SettingsFragmentContract.View mView;

    public SettingsFragmentPresenter(@NonNull SettingsFragmentContract.View view) {
        mView = view;
    }

    @Override
    public void subscribe(Context context) {
        loadValues(context);
    }

    private void loadValues(Context context) {
        String currentCity = SharedPreferenceUtil.getString(context, SharedPreferenceKeys.CURRENT_CITY, CityEnum.getDefault().name());

        RadioGroup.LayoutParams params;

        for (CityEnum cityEnum : CityEnum.values()){
            RadioButton radioButton = new RadioButton(context);
            radioButton.setId(cityEnum.getWoeid());
            radioButton.setText(cityEnum.getTitle());
            radioButton.setTextColor(ContextCompat.getColor(context, R.color.black));
            ColorStateList colorStateList = ViewUtil.getColorStateList();
            radioButton.setButtonTintList(colorStateList);;
            radioButton.setChecked(cityEnum.name().equalsIgnoreCase(currentCity));
            params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            mView.showRadioValues(radioButton, params);
        }
    }

    @Override
    public void unsubscribe() {}

    @Override
    public void setCheckedId(Context context, int checkedId) {
        try {
            CityEnum cityEnum = CityEnum.getByWoeid(checkedId);
            SharedPreferenceUtil.saveString(context, SharedPreferenceKeys.CURRENT_CITY, cityEnum.name());
        } catch (IllegalArgumentException e) {
            Log.d(TAG, "IllegalArgumentException: " + e.getLocalizedMessage());
        }
    }
}
