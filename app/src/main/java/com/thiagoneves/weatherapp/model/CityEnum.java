package com.thiagoneves.weatherapp.model;

public enum CityEnum {

    //TODO hardcoded only for testing
    SAN_FRANCISCO(2487956, "San Francisco"),
    LONDON(44418, "London"),
    MADRI(766273, "Madri");

    private final int woeid;
    private final String title;

    CityEnum(int woeid, String title) {
        this.woeid = woeid;
        this.title = title;
    }

    public int getWoeid() {
        return woeid;
    }

    public String getTitle() {
        return title;
    }

    public static CityEnum getByWoeid(int woeid) {
        for (CityEnum cityEnum : values()) {
            if (cityEnum.woeid == woeid) {
                return cityEnum;
            }
        }
        throw new IllegalArgumentException(String.valueOf(woeid));
    }

    public static CityEnum getByName(String name) {
        for (CityEnum cityEnum : values()) {
            if (cityEnum.name().equalsIgnoreCase(name)) {
                return cityEnum;
            }
        }
        throw new IllegalArgumentException(name);
    }

    public static CityEnum getDefault() {
        return MADRI;
    }
}
