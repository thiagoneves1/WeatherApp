package com.thiagoneves.weatherapp.model;

import junit.framework.TestCase;

public class CityValuesTest extends TestCase {

    public void testCityObjectIsOk() {

        CityEnum san_francisco = CityEnum.getByName("San_Francisco");
        assertNotNull(san_francisco);
        assertEquals(san_francisco, CityEnum.SAN_FRANCISCO);
    }

}