package com.thiagoneves.weatherapp.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class SharedPreferenceUtil {

    private static final String TAG = "SharedPreferenceUtil";

    public static void saveString(Context c, String key, String value) {
        getEditor(c).putString(key, value).apply();
    }

    private static SharedPreferences.Editor getEditor(Context c) {
        return getPrefs(c).edit();
    }

    private static SharedPreferences getPrefs(Context c) {
        return PreferenceManager.getDefaultSharedPreferences(c);
    }

    public static String getString(Context c, String key, String defaultValue) {
        try {
            return getPrefs(c).getString(key, defaultValue);
        } catch (ClassCastException e) {
            handleCastException(key, e);
            return defaultValue;
        }
    }
    private static void handleCastException(String key, Throwable t) {
        Log.d(TAG, "Caught exception accessing key: " + key);
        Log.d(TAG, "Caught exception message: " + t.getLocalizedMessage());

    }

}
