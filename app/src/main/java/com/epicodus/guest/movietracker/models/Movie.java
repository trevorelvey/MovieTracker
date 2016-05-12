package com.epicodus.guest.movietracker.models;

import org.parceler.Parcel;

@Parcel
public class Movie {
    private String title;
    private String director;
    private String year;
    private int rating;
    private String pushId;

    public Movie() {}

    public Movie(String title, String director, String year, int rating) {
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

    public int getRating() {
        return rating;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
