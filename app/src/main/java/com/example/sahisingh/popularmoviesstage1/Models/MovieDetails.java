package com.example.sahisingh.popularmoviesstage1.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class MovieDetails implements Parcelable {
    private String tittle;
    private String posterPath;
    private float vote_average;
    private String overview;
    private Date release_date;

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

    public String getModifiedPosterPath(){
        String modifiedPosterPath = "http://image.tmdb.org/t/p/";
        modifiedPosterPath += "w342";
        modifiedPosterPath +=getPosterPath();
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

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public MovieDetails() {
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
        parcel.writeLong(release_date.getTime());
    }

    protected MovieDetails(Parcel in){
        long tmpDate = in.readLong();
        this.release_date = tmpDate == -1 ? null : new Date(tmpDate);
    }


}
