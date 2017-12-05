package com.example.user.testtask.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by user on 03.12.2017.
 */

public class FilmRequestModel {
    @SerializedName("list")
    List<Film> list;

    public List<Film> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "FilmRequestModel{" +
                "list=" + list +
                '}';
    }
}
