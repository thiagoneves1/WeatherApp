package com.thiagoneves.weatherapp.util;

import androidx.annotation.NonNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

    public static final int DAYS_OF_WEEK = 7;

    //TODO replace to getNextWeekDaysFromNow
    public static String getToday() {
        Date date = getTodayDate();
        DateFormat formatter = getFormatter();
        return formatter.format(date);
    }

    @NonNull
    private static SimpleDateFormat getFormatter() {
        return new SimpleDateFormat("yyyy/MM/dd");
    }

    public static List<String> getNextWeekDaysFromNow() {
        Calendar calendar = Calendar.getInstance();
        DateFormat formatter = getFormatter();
        List<String> stringsDates = new ArrayList<>();
        for (int i = 1; i < DAYS_OF_WEEK; i++) {
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
