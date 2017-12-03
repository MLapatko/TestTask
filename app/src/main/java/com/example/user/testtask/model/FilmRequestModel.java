package com.example.user.testtask.model;

import java.util.List;

/**
 * Created by user on 03.12.2017.
 */

public class FilmRequestModel {
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
