package com.thiagoneves.weatherapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    public static final String BASE_URL = "https://www.metaweather.com/api/location/";

    private static Retrofit sRetrofit = null;

    public static Retrofit getApi(){
        if(sRetrofit == null){
            sRetrofit =new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }

}