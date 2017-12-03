package com.example.user.testtask.model;

/**
 * Created by user on 03.12.2017.
 */

public class Film {
    private String image;
    private String name;
    private String name_eng;
    private String premiere;
    private String description;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_eng() {
        return name_eng;
    }

    public void setName_eng(String name_eng) {
        this.name_eng = name_eng;
    }

    public String getPremiere() {
        return premiere;
    }

    public void setPremiere(String premiere) {
        this.premiere = premiere;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Film{" +
                "image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", name_eng='" + name_eng + '\'' +
                ", premiere='" + premiere + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
