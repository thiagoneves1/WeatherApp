package com.thiagoneves.weatherapp.db;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.thiagoneves.weatherapp.db.dbmodel.CityModel;
import com.thiagoneves.weatherapp.db.dbmodel.CityWeatherCrossRef;
import com.thiagoneves.weatherapp.db.dbmodel.WeatherAndInfoDayCrossRef;
import com.thiagoneves.weatherapp.db.dbmodel.WeatherInfoDayModel;
import com.thiagoneves.weatherapp.db.dbmodel.WeatherModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;




@Database(entities = {CityModel.class, CityWeatherCrossRef.class, WeatherModel.class, WeatherInfoDayModel.class, WeatherAndInfoDayCrossRef.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    @Nullable
    private static AppDatabase mInstance;


    @WorkerThread
    public static @Nullable AppDatabase getDatabaseIfInitialized(){
        return mInstance;
    }

    @WorkerThread
    public static void initialize(Context c) {
        getDatabase(c);
    }


    private static final int NUMBER_OF_THREADS = 1;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    @WorkerThread
    public static AppDatabase getDatabase(Context c){
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(c, AppDatabase.class, AppDatabaseConstants.DATABASE_FILENAME)
                    .build();
        }

        return mInstance;
    }
}
