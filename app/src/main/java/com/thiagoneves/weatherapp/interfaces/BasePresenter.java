package com.thiagoneves.weatherapp.interfaces;

import android.content.Context;

public interface BasePresenter {

    void subscribe(Context context);

    void unsubscribe();

}