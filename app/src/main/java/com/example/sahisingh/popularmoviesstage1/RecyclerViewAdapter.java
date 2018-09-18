package com.example.sahisingh.popularmoviesstage1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sahisingh.popularmoviesstage1.Models.MovieDetails;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MovieHolder> {
    //TODO create a field for data
    List<MovieDetails> movieDetailsList;
    private MovieItemClickListener movieItemClickListener;
    private LayoutInflater movieLayoutInflater;

    RecyclerViewAdapter(Context context, MovieItemClickListener movieItemClickListener){
        this.movieLayoutInflater = LayoutInflater.from(context);
        this.movieItemClickListener = movieItemClickListener;
    }

    public void setNews(List<MovieDetails> movieDetailsList){
        this.movieDetailsList = movieDetailsList;

    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = movieLayoutInflater.inflate(R.layout.recycler_view_layout,parent,false);

        return new MovieHolder(view);
    }
    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        MovieDetails movieDetails = movieDetailsList.get(position);


    }

    public class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView movieImageView;
        MovieHolder(View movieView){
            super(movieView);
            movieImageView = movieView.findViewById(R.id.imageView);

            movieImageView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            movieItemClickListener.onItemClick(getAdapterPosition());
        }
    }
    public interface MovieItemClickListener {
        void onItemClick(int position);
    }
}
