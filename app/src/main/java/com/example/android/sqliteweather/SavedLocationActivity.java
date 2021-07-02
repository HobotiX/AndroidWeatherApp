package com.example.android.sqliteweather;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.sqliteweather.data.ForecastItem;

public class SavedLocationActivity extends AppCompatActivity implements ForecastAdapter.OnForecastItemClickListener {

    private SavedLocationViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_locations);

        RecyclerView savedReposRV = findViewById(R.id.rv_saved_location);
        savedReposRV.setLayoutManager(new LinearLayoutManager(this));
        savedReposRV.setHasFixedSize(true);

        final ForecastAdapter adapter = new ForecastAdapter(this);
        savedReposRV.setAdapter(adapter);

        mViewModel = new ViewModelProvider(
                this,
                new ViewModelProvider.AndroidViewModelFactory(getApplication())
        ).get(SavedLocationViewModel.class);

        mViewModel.getAllLocation().observe(this, new Observer<List<ForecastItem>>() {
            @Override
            public void onChanged(List<ForecastItem> forecastItems) {
                adapter.updateForecastItems(forecastItems);
            }
        });
    }

    @Override
    public void onForecastItemClick(ForecastItem forecastItem) {
        Intent intent = new Intent(this, ForecastItemDetailActivity.class);
        intent.putExtra(ForecastItemDetailActivity.EXTRA_FORECAST_ITEM, forecastItem);
        startActivity(intent);
    }

}
