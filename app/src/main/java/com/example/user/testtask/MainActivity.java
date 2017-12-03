package com.example.user.testtask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.user.testtask.model.FilmRequestModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.getFilmsApi().getFilms().enqueue(new Callback<FilmRequestModel>() {
            @Override
            public void onResponse(Call<FilmRequestModel> call, Response<FilmRequestModel> response) {
                Log.e("mylog", response.body().toString());
            }

            @Override
            public void onFailure(Call<FilmRequestModel> call, Throwable t) {
                Log.e("mylog",t.toString());
            }
        });
    }
}
