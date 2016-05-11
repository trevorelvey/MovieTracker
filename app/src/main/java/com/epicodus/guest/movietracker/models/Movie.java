package com.epicodus.guest.movietracker.models;

import org.parceler.Parcel;

@Parcel
public class Movie {
    private String title;
    private String director;
    private String year;
    private double rating;
    private String pushId;

    public Movie() {}

    public Movie(String title, String director, String year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
