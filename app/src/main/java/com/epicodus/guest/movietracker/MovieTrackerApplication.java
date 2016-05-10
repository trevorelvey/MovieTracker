package com.epicodus.guest.movietracker;

import android.app.Application;

import com.firebase.client.Firebase;

public class MovieTrackerApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}