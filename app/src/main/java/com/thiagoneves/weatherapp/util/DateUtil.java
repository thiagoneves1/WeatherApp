package com.thiagoneves.weatherapp.util;


import android.content.Context;

import androidx.annotation.NonNull;

import com.thiagoneves.weatherapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

    public static final int DAYS_OF_WEEK = 7;


    @NonNull
    public static String getWeekDay(Context context, int intDay) {
        String[] weekDays = context.getResources().getStringArray(R.array.weekdays);
        return weekDays[intDay];
    }

    public static String getToday() {
        Date date = getTodayDate();
        DateFormat formatter = getFormatterToCallAPI();
        return formatter.format(date);
    }

    @NonNull
    public static SimpleDateFormat getFormatterToCallAPI() {
        return new SimpleDateFormat("yyyy/MM/dd");
    }

    @NonNull
    public static SimpleDateFormat getFormatterAPI() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    public static List<String> getNextWeekDaysFromNow() {
        Calendar calendar = WeatherCalendar.getCurrentInstance();
        DateFormat formatter = getFormatterToCallAPI();
        List<String> stringsDates = new ArrayList<>();
        for (int i = 1; i <= DAYS_OF_WEEK; i++) {
            stringsDates.add(formatter.format(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return stringsDates;
    }

    @NonNull
    private static Date getTodayDate() {
        return Calendar.getInstance().getTime();
    }


}
