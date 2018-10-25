package com.example.sahisingh.popularmoviesstage1.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.sahisingh.popularmoviesstage1.Constants;

public class MovieDetails implements Parcelable {
    public static final Creator<MovieDetails> CREATOR = new Creator<MovieDetails>() {
        @Override
        public MovieDetails createFromParcel(Parcel in) {
            return new MovieDetails(in);
        }

        @Override
        public MovieDetails[] newArray(int size) {
            return new MovieDetails[size];
        }
    };
    private String tittle;
    private String posterPath;
    private float vote_average;
    private String overview;
    private String release_date;

    public MovieDetails() {
    }

    private MovieDetails(Parcel in) {

        this.tittle = in.readString();
        this.posterPath = in.readString();
        this.vote_average = in.readFloat();
        this.overview = in.readString();

        this.release_date = in.readString();
    }

    public String getModifiedPosterPath() {
        String modifiedPosterPath = Constants.BASEURL;
        modifiedPosterPath += Constants.BASESIZE;
        modifiedPosterPath += getPosterPath();
        return modifiedPosterPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(tittle);
        parcel.writeString(posterPath);
        parcel.writeFloat(vote_average);
        parcel.writeString(overview);
        parcel.writeString(release_date);
    }

}
