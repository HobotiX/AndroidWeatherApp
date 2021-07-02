package com.example.android.sqliteweather.data;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class SavedLocationRepository {
    private SavedLocationDao mDAO;

    public SavedLocationRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mDAO = db.savedReposDao();
    }

    public void insertSavedRepo(ForecastItem repo) {
        new InsertAsyncTask(mDAO).execute(repo);
    }

    public void deleteSavedRepo(ForecastItem repo) {
        new DeleteAsyncTask(mDAO).execute(repo);
    }

    public LiveData<List<ForecastItem>> getAllRepos() {
        return mDAO.getAllRepos();
    }

    public LiveData<ForecastItem> getRepoByLocation(String location) {
        return mDAO.getRepoByLocation(location);
    }

    private static class InsertAsyncTask extends AsyncTask<ForecastItem, Void, Void> {
        private SavedLocationDao mAsyncTaskDAO;
        InsertAsyncTask(SavedLocationDao dao) {
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(ForecastItem... gitHubRepos) {
            mAsyncTaskDAO.insert(gitHubRepos[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<ForecastItem, Void, Void> {
        private SavedLocationDao mAsyncTaskDAO;
        DeleteAsyncTask(SavedLocationDao dao) {
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(ForecastItem... gitHubRepos) {
            mAsyncTaskDAO.delete(gitHubRepos[0]);
            return null;
        }
    }
}
