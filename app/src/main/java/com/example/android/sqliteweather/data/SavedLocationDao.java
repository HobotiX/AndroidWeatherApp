package com.example.android.sqliteweather.data;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface SavedLocationDao {
    @Insert
    void insert(ForecastItem repo);

    @Delete
    void delete(ForecastItem repo);

    @Query("SELECT * FROM forcast")
    LiveData<List<ForecastItem>> getAllRepos();

    @Query("SELECT * FROM forcast WHERE location = :location LIMIT 1")
    LiveData<ForecastItem> getRepoByLocation(String location);
}
