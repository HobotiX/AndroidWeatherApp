package com.example.android.sqliteweather.data;

import java.io.Serializable;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*
 * This is the class that's used to represent an individual forecast item throughout the app.
 */
@Entity(tableName = "forcast")
public class ForecastItem implements Serializable {
    @PrimaryKey
    @NonNull
    public Date dateTime;
    public String description;
    public String icon;
    public long temperature;
    public long temperatureLow;
    public long temperatureHigh;
    public long humidity;
    public long windSpeed;
    public String windDirection;
}
