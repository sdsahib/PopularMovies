package com.example.sahisingh.popularmoviesstage1.utilities;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtil {

    final static String THE_MOVIE_DB_BASE_URL = "http://api.themoviedb.org/3/discover/movie";


    public static URL buildMostPopularMovieUrl(){
        Uri buildUri = Uri.parse(THE_MOVIE_DB_BASE_URL).buildUpon().
                appendQueryParameter("sort_by","popularity.desc")
                .appendQueryParameter("api_key","1d96fca82c21d87478c29792f878e414")
                .build();

        URL url = null;
        try {
            url = new URL(buildUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static URL buildHighestRatedMovieUrl(){


        Uri buildUri = Uri.parse(THE_MOVIE_DB_BASE_URL).buildUpon().
                appendQueryParameter("certification_country","US").
                appendQueryParameter("certification","R").
                appendQueryParameter("sort_by","vote_average.desc")
                .appendQueryParameter("api_key","1d96fca82c21d87478c29792f878e414")
                .build();

        URL url = null;
        try {
            url = new URL(buildUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
