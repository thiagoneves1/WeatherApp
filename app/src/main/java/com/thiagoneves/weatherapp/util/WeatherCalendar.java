package com.thiagoneves.weatherapp.util;

import androidx.annotation.Nullable;

import java.util.Calendar;

public class WeatherCalendar {
    private @Nullable
    static Calendar sFakeCurrentCalendarInstanceForTestingOnly;

    public static Calendar getCurrentInstance() {
        if (sFakeCurrentCalendarInstanceForTestingOnly != null) {
            return (Calendar) sFakeCurrentCalendarInstanceForTestingOnly.clone();
        } else {
            return Calendar.getInstance();
        }
    }

    public static void setFakeCurrentCalendarInstanceFOR_TESTING_ONLY(Calendar c) {
        sFakeCurrentCalendarInstanceForTestingOnly = (Calendar) c.clone();
    }
}