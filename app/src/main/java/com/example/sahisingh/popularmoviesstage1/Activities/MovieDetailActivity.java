package com.example.sahisingh.popularmoviesstage1.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.sahisingh.popularmoviesstage1.R;
import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ImageView moviePoster = findViewById(R.id.movie_poster);
        Picasso.get().load(R.drawable.nointernet).into(moviePoster);
    }
}
