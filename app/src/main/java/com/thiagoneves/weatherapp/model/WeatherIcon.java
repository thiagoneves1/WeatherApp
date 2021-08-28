package com.thiagoneves.weatherapp.model;

import com.thiagoneves.weatherapp.R;

public enum WeatherIcon {
    SNOW(R.drawable.ic_snow, "snow"),
    SLEET(R.drawable.ic_sleet, "sleet"),
    HAIL(R.drawable.ic_hail, "hail"),
    THUNDERSTORM(R.drawable.ic_thunderstorm, "thunderstorm"),
    HEAVY_RAIN(R.drawable.ic_heavy_rain, "Heavy Rain"),
    LIGHT_RAIN(R.drawable.ic_heavy_rain, "Light Rain"),
    SHOWERS(R.drawable.ic_heavy_rain, "showers"),
    HEAVY_CLOUD(R.drawable.ic_heavy_cloud, "Heavy Cloud"),
    LIGHT_CLOUD(R.drawable.ic_light_cloud, "Light Cloud"),
    CLEAR(R.drawable.ic_clear, "clear");

    private final int drawableId;
    private final String apiName;

    WeatherIcon(int drawableId, String apiName) {
        this.drawableId = drawableId;
        this.apiName = apiName;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public String getApiName() {
        return apiName;
    }

    public static WeatherIcon getByApiName(String name) {
        for (WeatherIcon weather : values()) {
            if (weather.getApiName().equalsIgnoreCase(name)) {
                return weather;
            }
        }
        throw new IllegalArgumentException(name);
    }
}
