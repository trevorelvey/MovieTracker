package com.epicodus.guest.movietracker.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.epicodus.guest.movietracker.Constants;
import com.epicodus.guest.movietracker.R;
import com.epicodus.guest.movietracker.models.Movie;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import org.parceler.Parcels;

import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddMovie extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = CreateAccountActivity.class.getSimpleName();
    @Bind(R.id.submitMovieButton) Button mAddMovieButton;
    @Bind(R.id.titleEditText) EditText mTitleEditText;
    @Bind(R.id.directorEditText) EditText mDirectorEditText;
    @Bind(R.id.yearEditText) EditText mYearEditText;
    @Bind(R.id.ratingBar) RatingBar mRatingBar;
    private Firebase mFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);
        ButterKnife.bind(this);
        mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
        mAddMovieButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mAddMovieButton) {
            createNewMovie();
        }
    }

    public void createNewMovie() {
        final String title = mTitleEditText.getText().toString();
        final String director = mDirectorEditText.getText().toString();
        final String year = mYearEditText.getText().toString();
        final double rating = mRatingBar.getNumStars();
        Movie movie = new Movie(title, director, year, rating);

        String uid = mFirebaseRef.getAuth().getUid();
        Firebase movieRef = new Firebase(Constants.FIREBASE_URL_SAVED_MOVIE).child(uid);
        Firebase pushRef = movieRef.push();
        String key = pushRef.getKey();

        movie.setPushId(key);
        pushRef.setValue(movie);
    }
}
