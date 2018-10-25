package com.example.sahisingh.popularmoviesstage1.utilities;

import android.net.Uri;

import com.example.sahisingh.popularmoviesstage1.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtil {


    public static URL buildMostPopularMovieUrl() {
        Uri buildUri = Uri.parse(Constants.THE_MOVIE_DB_BASE_URL).buildUpon().
                appendQueryParameter(Constants.SORTBY, Constants.SORTBYPOPULARITY)
                .appendQueryParameter(Constants.APIKEY, Constants.APIKEYVALUE)
                .build();

        URL url = null;
        try {
            url = new URL(buildUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static URL buildHighestRatedMovieUrl() {


        Uri buildUri = Uri.parse(Constants.THE_MOVIE_DB_BASE_URL).buildUpon().
                appendQueryParameter(Constants.CERTIFICATIONCOUNTRY, Constants.CERTIFICATIONCOUNTRYUS).
                appendQueryParameter(Constants.CERTIFICATION, Constants.CERTIFICATION_R).
                appendQueryParameter(Constants.SORTBY, Constants.VOTEAVERAGE_DESC)
                .appendQueryParameter(Constants.APIKEY, Constants.APIKEYVALUE)
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
