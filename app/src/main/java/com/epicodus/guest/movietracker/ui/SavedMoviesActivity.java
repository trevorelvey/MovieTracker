package com.epicodus.guest.movietracker.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epicodus.guest.movietracker.Constants;
import com.epicodus.guest.movietracker.R;
import com.epicodus.guest.movietracker.models.Movie;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedMoviesActivity extends AppCompatActivity {
    private Query mQuery;
    private Firebase mFirebaseMoviesRef;
    private FirebaseMovieListAdapter mAdapter;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_movies);
        ButterKnife.bind(this);

        mFirebaseMoviesRef = new Firebase(Constants.FIREBASE_URL_SAVED_MOVIE);

        setUpFirebaseQuery();
        setUpRecyclerView();
    }

    private void setUpFirebaseQuery() {
        String location = mFirebaseMoviesRef.toString();
        mQuery = new Firebase(location);
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseMovieListAdapter(mQuery, Movie.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}
