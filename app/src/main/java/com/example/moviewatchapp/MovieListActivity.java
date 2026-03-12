package com.example.moviewatchapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviewatchapp.adapters.MovieAdapter;
import com.example.moviewatchapp.models.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {

    private RecyclerView recyclerMovies;
    private TextView txtCategoryTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        recyclerMovies = findViewById(R.id.recyclerMovies);
        txtCategoryTitle = findViewById(R.id.txtCategoryTitle);

        recyclerMovies.setLayoutManager(new GridLayoutManager(this, 2));

        String categoryName = getIntent().getStringExtra("categoryName");
        txtCategoryTitle.setText(categoryName);

        List<MovieModel> movieList = new ArrayList<>();

        if ("Action".equals(categoryName)) {
            movieList.add(new MovieModel(R.drawable.action_01, "XXX"));
            movieList.add(new MovieModel(R.drawable.action_02, "Extraction"));
            movieList.add(new MovieModel(R.drawable.action_03, "Super 8"));
            movieList.add(new MovieModel(R.drawable.action_04, "Red one"));
            movieList.add(new MovieModel(R.drawable.action_05, "Jurasic Worl"));
            movieList.add(new MovieModel(R.drawable.action_06, "Body of Lies"));
            movieList.add(new MovieModel(R.drawable.action_07, "Lord of Rings"));
            movieList.add(new MovieModel(R.drawable.action_08, "Equalizer"));
            movieList.add(new MovieModel(R.drawable.action_09, "Matrix"));

        } else if ("Comedy".equals(categoryName)) {
            movieList.add(new MovieModel(R.drawable.comedy_01, "Due Date"));
            movieList.add(new MovieModel(R.drawable.comedy_02, "Where the millers"));

        } else if ("Horror".equals(categoryName)) {
            movieList.add(new MovieModel(R.drawable.horror_01, "IT"));
            movieList.add(new MovieModel(R.drawable.horror_02, "Anebelle"));

        } else if ("Drama".equals(categoryName)) {
            movieList.add(new MovieModel(R.drawable.drama_01, "A Big Bold Beautifu Journey"));
            movieList.add(new MovieModel(R.drawable.drama_02, "Steve"));

        } else if ("Romance".equals(categoryName)) {
            movieList.add(new MovieModel(R.drawable.romance_01, "NoteBook"));
            movieList.add(new MovieModel(R.drawable.romance_02, "American Romance"));

        } else if ("Sci-Fi".equals(categoryName)) {
            movieList.add(new MovieModel(R.drawable.scifi_01, "Mercy"));
            movieList.add(new MovieModel(R.drawable.scifi_02, "The Great Flood"));
        }

        MovieAdapter adapter = new MovieAdapter(movieList);
        recyclerMovies.setAdapter(adapter);
    }
}