package com.example.sahisingh.popularmoviesstage1.utilities;

import android.os.AsyncTask;
import android.util.Log;

import com.example.sahisingh.popularmoviesstage1.Activities.MainActivity;
import com.example.sahisingh.popularmoviesstage1.Models.MovieDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MoviesTask extends AsyncTask<URL,Void, ArrayList<MovieDetails>> {

    @Override
    protected ArrayList<MovieDetails> doInBackground(URL... urls) {
        URL searchUrl = urls[0];
        String MovieDBSearchResults = null;
        ArrayList<MovieDetails> details = new ArrayList<>();
        try {
            MovieDBSearchResults = NetworkUtil.getResponseFromHttpUrl(searchUrl);
            Log.d("MOVIESTASK", "doInBackground: " + MovieDBSearchResults);
            JSONObject jsonResponse = new JSONObject(MovieDBSearchResults);
            JSONArray jsonArray = jsonResponse.optJSONArray("results");

            for(int i=0;i<jsonArray.length();i++){
                JSONObject fetchedMovie = jsonArray.getJSONObject(i);
                Log.d("MOVIESTASK", "doInBackground: " + fetchedMovie);
                MovieDetails movieDetails = new MovieDetails();
                movieDetails.setTittle(fetchedMovie.optString("title"));
                movieDetails.setPosterPath(fetchedMovie.optString("poster_path"));
                movieDetails.setOverview(fetchedMovie.optString("overview"));

                String dateToConvert = fetchedMovie.optString("release_date");
                String[] splittedDate = dateToConvert.split("-");
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, Integer.parseInt(splittedDate[0]));
                calendar.set(Calendar.MONTH,Integer.parseInt(splittedDate[1]));
                calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(splittedDate[2]));

                Date fetchedDate = calendar.getTime();

                movieDetails.setRelease_date(fetchedDate);
                movieDetails.setVote_average(fetchedMovie.optInt("vote_average"));

                details.add(movieDetails);
            }

            Log.d("ArrayLIst", "doInBackground: " + details);

        } catch (IOException e) {
            e.printStackTrace();
        }catch(JSONException e){
            e.printStackTrace();
        }
        return details;
    }

    @Override
    protected void onPostExecute(ArrayList<MovieDetails> movieDetails) {
        super.onPostExecute(movieDetails);
        MainActivity.adapter.setNews(movieDetails);
        MainActivity.adapter.notifyDataSetChanged();
    }
}
