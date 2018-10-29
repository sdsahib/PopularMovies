package com.example.sahisingh.popularmoviesstage1;

public class Constants {
    public final static String RESULTS;
    public final static String POSTERPATH;
    public final static String OVERVIEW;
    public final static String RELEASEDATE;
    public final static String VOTEAVERAGE;
    public final static String BASEURL;
    public final static String BASESIZE;
    public final static String THE_MOVIE_DB_BASE_URL;
    public final static String SORTBY;
    public final static String APIKEY;
    public final static String SORTBYPOPULARITY;
    public final static String APIKEYVALUE;
    public final static String CERTIFICATIONCOUNTRY;
    public final static String CERTIFICATION;
    public final static String CERTIFICATIONCOUNTRYUS;
    public final static String CERTIFICATION_R;
    public final static String VOTEAVERAGE_DESC;
    public final static String POPULAR_API;
    public final static String TOP_RATED;

    static {
        RESULTS = "results";
        POSTERPATH = "poster_path";
        OVERVIEW = "overview";
        RELEASEDATE = "release_date";
        VOTEAVERAGE = "vote_average";
        BASEURL = "http://image.tmdb.org/t/p/";
        BASESIZE = "w342";
        THE_MOVIE_DB_BASE_URL = "http://api.themoviedb.org/3/movie/";
        POPULAR_API = THE_MOVIE_DB_BASE_URL+ "popular";
        TOP_RATED = THE_MOVIE_DB_BASE_URL + "top_rated";
        SORTBY = "sort_by";
        APIKEY = "api_key";
        SORTBYPOPULARITY = "popularity.desc";
        APIKEYVALUE = "YOUR_API_KEY";
        CERTIFICATIONCOUNTRY = "certification_country";
        CERTIFICATION = "certification";
        CERTIFICATIONCOUNTRYUS = "US";
        CERTIFICATION_R = "R";
        VOTEAVERAGE_DESC = "vote_average.desc";

    }
}
