package com.epicodus.guest.movietracker.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.epicodus.guest.movietracker.R;
import com.epicodus.guest.movietracker.models.Movie;


import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    private ArrayList<Movie> mMovies = new ArrayList<>();
    private Context mContext;

    public MovieListAdapter(Context context, ArrayList<Movie> movies) {
        mContext = context;
        mMovies = movies;
    }

    @Override
    public MovieListAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieListAdapter.MovieViewHolder holder, int position) {
        holder.bindMovie(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.movieNameTextView) TextView mMovieNameTextView;
        @Bind(R.id.directorTextView) TextView mDirectorTextView;
        @Bind(R.id.yearTextView) TextView mYearTextView;
        @Bind(R.id.ratingBarView) RatingBar mRatingBarView;
        private Context mContext;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindMovie(Movie movie) {
            mMovieNameTextView.setText(movie.getTitle());
            mDirectorTextView.setText(movie.getDirector());
            mYearTextView.setText(movie.getYear());
            mRatingBarView.setNumStars(movie.getRating());
        }
    }
}
