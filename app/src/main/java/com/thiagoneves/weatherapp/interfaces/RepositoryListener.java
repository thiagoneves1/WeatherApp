package com.thiagoneves.weatherapp.interfaces;

import com.thiagoneves.weatherapp.model.City;

public interface RepositoryListener {

    void loadedInfoForCity(City city);
}