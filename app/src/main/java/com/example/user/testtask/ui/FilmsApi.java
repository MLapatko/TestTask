package com.example.user.testtask.ui;

import com.example.user.testtask.model.FilmRequestModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by user on 03.12.2017.
 */

public interface FilmsApi {
    @GET("/v2/57cffac8260000181e650041")
    Call<FilmRequestModel> getFilms();
}
