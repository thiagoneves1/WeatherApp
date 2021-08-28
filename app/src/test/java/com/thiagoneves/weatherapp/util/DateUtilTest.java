package com.thiagoneves.weatherapp.util;

import static com.thiagoneves.weatherapp.util.DateUtil.DAYS_OF_WEEK;

import junit.framework.TestCase;

import java.util.Calendar;
import java.util.List;

public class DateUtilTest extends TestCase {

    public static final int FIRST_POSITION = 0;
    public static final int LAST_POSITION = 6;

    public void testGetNextWeekDaysFromNowSize() {
        List<String> nextWeekDaysFromNow = DateUtil.getNextWeekDaysFromNow();
        assertEquals(nextWeekDaysFromNow.size(), DAYS_OF_WEEK);

    }

    public void testGetNextWeekDaysFromNowBetweenMonths() {


        Calendar fakeCurrentTime = Calendar.getInstance();
        fakeCurrentTime.set(Calendar.DAY_OF_MONTH, 31);
        fakeCurrentTime.set(Calendar.MONTH, Calendar.AUGUST);
        fakeCurrentTime.set(Calendar.YEAR, 2021);
        WeatherCalendar.setFakeCurrentCalendarInstanceFOR_TESTING_ONLY(fakeCurrentTime);

        List<String> nextWeekDaysFromNow = DateUtil.getNextWeekDaysFromNow();

        assert (nextWeekDaysFromNow.get(FIRST_POSITION).equalsIgnoreCase("2021/08/31"));
        assert (nextWeekDaysFromNow.get(LAST_POSITION).equalsIgnoreCase("2021/09/06"));

    }
}