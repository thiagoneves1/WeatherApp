package com.thiagoneves.weatherapp.model;

public enum City {
    //TODO hardcoded only for testing
    SAN_FRANCISCO(2487956),
    LONDON(44418),
    MADRI(766273);

    private final int woeid;

    City(int woeid) {
        this.woeid = woeid;
    }

    public int getWoeid() {
        return woeid;
    }
}
