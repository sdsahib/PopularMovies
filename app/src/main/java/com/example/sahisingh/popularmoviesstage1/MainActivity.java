package com.example.sahisingh.popularmoviesstage1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.sahisingh.popularmoviesstage1.Models.MovieDetails;
import com.example.sahisingh.popularmoviesstage1.utilities.MoviesTask;
import com.example.sahisingh.popularmoviesstage1.utilities.NetworkUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.MovieItemClickListener{


    RecyclerView recyclerView;
    ArrayList arrayList;
    public static RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        new MoviesTask().execute(NetworkUtil.buildMostPopularMovieUrl());

        arrayList = new ArrayList();



        adapter = new RecyclerViewAdapter(this,this,arrayList);
//        adapter.setNews(arrayList);
//        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this,
                2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);


    }

    @Override
    public void onItemClick(MovieDetails movieDetails) {
        Toast.makeText(getApplicationContext(), movieDetails.getTittle() + " is clicked", Toast.LENGTH_SHORT).show();

    }
}
