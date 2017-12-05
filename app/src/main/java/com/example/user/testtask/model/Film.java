package com.example.user.testtask.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 03.12.2017.
 */

public class Film implements Parcelable{

    @SerializedName("image")
    private String image;
    @SerializedName("name")
    private String name;
    @SerializedName("name_eng")
    private String name_eng;
    @SerializedName("premiere")
    private String premiere;
    @SerializedName("description")
    private String description;

    public Film(Parcel in) {
        image=in.readString();
        name=in.readString();
        name_eng=in.readString();
        premiere=in.readString();
        description=in.readString();
    }

    public Film() {}

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(image);
        parcel.writeString(name);
        parcel.writeString(name_eng);
        parcel.writeString(premiere);
        parcel.writeString(description);
    }
    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int i) {
            return new Film[i];
        }
    };
}
