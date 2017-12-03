package com.example.user.testtask;

import android.app.Application;

import com.example.user.testtask.ui.FilmsApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 03.12.2017.
 */

public class App extends Application {
    private Retrofit retrofit;
    private static FilmsApi filmsApi;
    String url="http://www.mocky.io";

    @Override
    public void onCreate() {
        super.onCreate();
        retrofit = new Retrofit
                .Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        filmsApi=retrofit.create(FilmsApi.class);
    }
    public static FilmsApi getFilmsApi(){return filmsApi;}
}
