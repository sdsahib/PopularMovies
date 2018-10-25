package com.example.sahisingh.popularmoviesstage1.utilities;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.example.sahisingh.popularmoviesstage1.Activities.MainActivity;
import com.example.sahisingh.popularmoviesstage1.Constants;
import com.example.sahisingh.popularmoviesstage1.Models.MovieDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MoviesTask extends AsyncTask<URL, Void, ArrayList<MovieDetails>> {

    private ProgressBar progressBar;

    public MoviesTask(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {

        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected ArrayList<MovieDetails> doInBackground(URL... urls) {
        URL searchUrl = urls[0];
        String MovieDBSearchResults;
        ArrayList<MovieDetails> details = new ArrayList<>();
        try {
            MovieDBSearchResults = NetworkUtil.getResponseFromHttpUrl(searchUrl);

            JSONObject jsonResponse = new JSONObject(MovieDBSearchResults);
            JSONArray jsonArray = jsonResponse.optJSONArray(Constants.RESULTS);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject fetchedMovie = jsonArray.getJSONObject(i);

                MovieDetails movieDetails = new MovieDetails();
                String TITLE = "title";
                movieDetails.setTittle(fetchedMovie.optString(TITLE));
                movieDetails.setPosterPath(fetchedMovie.optString(Constants.POSTERPATH));
                movieDetails.setOverview(fetchedMovie.optString(Constants.OVERVIEW));


                movieDetails.setRelease_date(fetchedMovie.optString(Constants.RELEASEDATE));
                movieDetails.setVote_average(fetchedMovie.optInt(Constants.VOTEAVERAGE));

                details.add(movieDetails);
            }


        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return details;
    }

    @Override
    protected void onPostExecute(ArrayList<MovieDetails> movieDetails) {
        super.onPostExecute(movieDetails);
        progressBar.setVisibility(View.INVISIBLE);
        MainActivity.adapter.setNews(movieDetails);
        MainActivity.adapter.notifyDataSetChanged();
    }
}
