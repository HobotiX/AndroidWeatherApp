package com.example.android.sqliteweather;

import android.app.Application;

import com.example.android.sqliteweather.data.SavedLocationRepository;
import com.example.android.sqliteweather.data.ForecastItem;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class SavedLocationViewModel extends AndroidViewModel {
    private SavedLocationRepository mRepository;

    public SavedLocationViewModel(Application application) {
        super(application);
        mRepository = new SavedLocationRepository(application);
    }

    public void insertSavedLocation(ForecastItem repo) {
        mRepository.insertSavedRepo(repo);
    }

    public void deleteSavedLocation(ForecastItem repo) {
        mRepository.deleteSavedRepo(repo);
    }

    public LiveData<List<ForecastItem>> getAllLocation() {
        return mRepository.getAllRepos();
    }

    public LiveData<ForecastItem> getRepoByLocation(String location) {
        return mRepository.getRepoByLocation(location);
    }
}
