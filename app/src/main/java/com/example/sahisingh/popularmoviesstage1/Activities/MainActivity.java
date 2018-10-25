package com.example.sahisingh.popularmoviesstage1.Activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.example.sahisingh.popularmoviesstage1.Models.MovieDetails;
import com.example.sahisingh.popularmoviesstage1.R;
import com.example.sahisingh.popularmoviesstage1.RecyclerViewAdapter;
import com.example.sahisingh.popularmoviesstage1.utilities.MoviesTask;
import com.example.sahisingh.popularmoviesstage1.utilities.NetworkUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.MovieItemClickListener {


    public static RecyclerViewAdapter adapter;
    public ProgressBar progressBar;
    RecyclerView recyclerView;
    ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);


        if (isOnline()) {
            loadMostPopularMovies(progressBar);
            arrayList = new ArrayList();

            adapter = new RecyclerViewAdapter(this, this, arrayList);
            recyclerView.setAdapter(adapter);

            GridLayoutManager manager = new GridLayoutManager(this,
                    2, GridLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(manager);

        } else {
            Snackbar snackbar = Snackbar
                    .make(recyclerView, R.string.connection_warning, Snackbar.LENGTH_LONG);
            snackbar.show();
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_fetch_most_popular:
                loadMostPopularMovies(progressBar);
                return true;
            case R.id.action_fetch_highest_rated:
                loadHighestRatedMovies(progressBar);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void loadMostPopularMovies(ProgressBar progressBar) {
        new MoviesTask(progressBar).execute(NetworkUtil.buildMostPopularMovieUrl());
        setTitle(R.string.most_popular_app_name);
    }

    public void loadHighestRatedMovies(ProgressBar progressBar) {
        new MoviesTask(progressBar).execute(NetworkUtil.buildHighestRatedMovieUrl());
        setTitle(R.string.highest_rated_app_name);
    }

    @Override
    public void onItemClick(MovieDetails movieDetails) {

        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra("movieData", movieDetails);
        startActivity(intent);

    }

    public boolean isOnline() {
        NetworkInfo netInfo = null;
        try {
            ConnectivityManager cm =
                    (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
             netInfo = cm.getActiveNetworkInfo();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
