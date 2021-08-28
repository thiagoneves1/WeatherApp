package com.thiagoneves.weatherapp.interfaces;

import android.content.Context;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public interface SettingsFragmentContract {

    interface View {

        void showRadioValues(RadioButton radioButton, RadioGroup.LayoutParams params);

    }

    interface Presenter extends BasePresenter {

        void setCheckedId(Context context, int checkedId);

    }
}