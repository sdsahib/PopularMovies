package com.example.sahisingh.popularmoviesstage1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sahisingh.popularmoviesstage1.Models.MovieDetails;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MovieHolder> {
    //TODO create a field for data
    List<MovieDetails> movieDetailsList;
    private MovieItemClickListener movieItemClickListener;
    private LayoutInflater movieLayoutInflater;

    RecyclerViewAdapter(Context context, MovieItemClickListener movieItemClickListener,List<MovieDetails> movieDetails){
        this.movieDetailsList = movieDetails;
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
        return movieDetailsList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        MovieDetails movieDetails = movieDetailsList.get(position);

        Log.d("SETTING", "onBindViewHolder: " + position + movieDetails.getName());
        holder.setData(movieDetails);


    }

    public class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//        ImageView movieImageView;
        TextView textView ;
        MovieDetails movieDetails;
        MovieHolder(View movieView){
            super(movieView);
//            movieImageView = movieView.findViewById(R.id.imageView);
            textView = movieView.findViewById(R.id.textView);

            textView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {

            movieItemClickListener.onItemClick(movieDetails);
        }

        public void setData(MovieDetails movieDetails){
            this.movieDetails = movieDetails;
            textView.setText(movieDetails.getName());

        }
    }
    public interface MovieItemClickListener {
        void onItemClick(MovieDetails movieDetails);
    }
}
