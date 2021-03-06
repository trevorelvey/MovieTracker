package com.epicodus.guest.movietracker;

public class Constants {
    public static final String FIREBASE_URL = BuildConfig.FIREBASE_ROOT_URL;
    public static final String FIREBASE_LOCATION_USERS = "users";
    public static final String FIREBASE_PROPERTY_EMAIL = "email";
    public static final String KEY_UID = "UID";
    public static final String FIREBASE_URL_USERS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USERS;
    public static final String KEY_USER_EMAIL = "email";
    public static final String FIREBASE_LOCATION_SAVED_MOVIE = "savedMovie";
    public static final String FIREBASE_URL_SAVED_MOVIE = FIREBASE_URL + "/" + FIREBASE_LOCATION_SAVED_MOVIE;
}
