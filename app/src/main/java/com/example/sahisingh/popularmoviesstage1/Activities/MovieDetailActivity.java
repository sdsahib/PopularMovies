package com.example.sahisingh.popularmoviesstage1.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sahisingh.popularmoviesstage1.Models.MovieDetails;
import com.example.sahisingh.popularmoviesstage1.R;
import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        setTitle(R.string.movie_detail);

        TextView movieTitle = findViewById(R.id.movie_title);
        ImageView moviePoster = findViewById(R.id.movie_poster);
        TextView releaseDate = findViewById(R.id.year_of_release);
        TextView showTime = findViewById(R.id.show_time);
        TextView movieRating = findViewById(R.id.movie_rating);
        TextView movieDescription = findViewById(R.id.movie_description);

        MovieDetails movieDetails = getIntent().getParcelableExtra("movieData");

        movieTitle.setText(movieDetails.getTittle());
        Picasso.get().load(movieDetails.getModifiedPosterPath()).into(moviePoster);
        releaseDate.setText(movieDetails.getRelease_date());
        movieRating.setText((int) movieDetails.getVote_average() + "/10.0");
        movieDescription.setText(movieDetails.getOverview());
    }
}
