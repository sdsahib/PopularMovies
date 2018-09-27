package com.example.sahisingh.popularmoviesstage1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.sahisingh.popularmoviesstage1.Models.MovieDetails;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.MovieItemClickListener{

    RecyclerView recyclerView;
    ArrayList arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        arrayList = new ArrayList();

        arrayList.add(new MovieDetails("First"));
        arrayList.add(new MovieDetails("Second"));
        arrayList.add(new MovieDetails("Third"));
        arrayList.add(new MovieDetails("Fourth"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,this,arrayList);
//        adapter.setNews(arrayList);
//        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this,
                2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);


    }

    @Override
    public void onItemClick(MovieDetails movieDetails) {
        Toast.makeText(getApplicationContext(), movieDetails.getName() + " is clicked", Toast.LENGTH_SHORT).show();

    }
}
