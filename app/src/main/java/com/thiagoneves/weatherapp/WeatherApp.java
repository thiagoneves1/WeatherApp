package com.thiagoneves.weatherapp;

import android.app.Application;
import android.util.Log;

import com.thiagoneves.weatherapp.db.AppDatabase;

public class WeatherApp extends Application {
    private static final String TAG = "WeatherApp";
    @Override
    public void onCreate() {

        new Thread() {
            public void run() {
                try {
                    AppDatabase.initialize(getApplicationContext());
                } catch (Exception e) {
                    Log.d(TAG, "Exception: " + e.getLocalizedMessage());
                }
            }
        }.start();
        super.onCreate();
    }
}
