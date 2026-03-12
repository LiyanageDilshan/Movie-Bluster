package com.example.moviewatchapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MovieDetailsActivity extends AppCompatActivity {

    ImageView imgMoviePoster;
    TextView txtMovieTitle, txtMeta, txtStory, txtCast;
    RatingBar ratingBar;
    EditText etReview;
    Button btnWishlist, btnSubmitReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        imgMoviePoster = findViewById(R.id.imgMoviePoster);
        txtMovieTitle = findViewById(R.id.txtMovieTitle);
        txtMeta = findViewById(R.id.txtMeta);
        txtStory = findViewById(R.id.txtStory);
        txtCast = findViewById(R.id.txtCast);
        ratingBar = findViewById(R.id.ratingBar);
        etReview = findViewById(R.id.etReview);
        btnWishlist = findViewById(R.id.btnWishlist);
        btnSubmitReview = findViewById(R.id.btnSubmitReview);

        String movieTitle = getIntent().getStringExtra("movieTitle");
        int movieImage = getIntent().getIntExtra("movieImage", 0);

        txtMovieTitle.setText(movieTitle);
        imgMoviePoster.setImageResource(movieImage);

        if ("Blade Runner 2049".equals(movieTitle)) {
            txtMeta.setText("2017 • 163m");
            txtStory.setText("A young blade runner discovers a buried secret that leads him to find former blade runner Rick Deckard, who has been missing for thirty years.");
            txtCast.setText("Ryan Gosling, Harrison Ford, Ana de Armas, Jared Leto");

        } else if ("Mad Max: Fury Road".equals(movieTitle)) {
            txtMeta.setText("2015 • 120m");
            txtStory.setText("In a desert wasteland, Max teams up with Furiosa to escape a tyrant and survive a high-speed war across the barren lands.");
            txtCast.setText("Tom Hardy, Charlize Theron, Nicholas Hoult");

        } else if ("John Wick".equals(movieTitle)) {
            txtMeta.setText("2014 • 101m");
            txtStory.setText("An ex-hitman comes out of retirement to hunt the gangsters who destroyed the last gift from his late wife.");
            txtCast.setText("Keanu Reeves, Michael Nyqvist, Alfie Allen");

        } else if ("The Dark Knight".equals(movieTitle)) {
            txtMeta.setText("2008 • 152m");
            txtStory.setText("Batman faces the Joker, a criminal mastermind who pushes Gotham into chaos and forces Batman to confront impossible choices.");
            txtCast.setText("Christian Bale, Heath Ledger, Aaron Eckhart");

        } else if ("Gladiator".equals(movieTitle)) {
            txtMeta.setText("2000 • 155m");
            txtStory.setText("A betrayed Roman general seeks revenge against the corrupt emperor who murdered his family and stole his future.");
            txtCast.setText("Russell Crowe, Joaquin Phoenix, Connie Nielsen");

        } else if ("Inception".equals(movieTitle)) {
            txtMeta.setText("2010 • 148m");
            txtStory.setText("A skilled thief enters dreams to steal secrets, but this time he must plant an idea deep in a target's subconscious.");
            txtCast.setText("Leonardo DiCaprio, Joseph Gordon-Levitt, Elliot Page");

        } else if ("Mission Impossible".equals(movieTitle)) {
            txtMeta.setText("1996 • 110m");
            txtStory.setText("Ethan Hunt is framed for a failed mission and must uncover the real traitor while staying ahead of his own agency.");
            txtCast.setText("Tom Cruise, Jon Voight, Emmanuelle Beart");

        } else if ("Avengers Endgame".equals(movieTitle)) {
            txtMeta.setText("2019 • 181m");
            txtStory.setText("The Avengers assemble one final time to undo Thanos' destruction and restore balance to the universe.");
            txtCast.setText("Robert Downey Jr., Chris Evans, Scarlett Johansson");

        } else if ("Extraction".equals(movieTitle)) {
            txtMeta.setText("2020 • 116m");
            txtStory.setText("A fearless mercenary is hired to rescue the kidnapped son of an international crime lord in a deadly mission.");
            txtCast.setText("Chris Hemsworth, Rudhraksh Jaiswal, Randeep Hooda");

        } else {
            txtMeta.setText("2024 • 120m");
            txtStory.setText("Movie description not added yet.");
            txtCast.setText("Cast details not added yet.");
        }

        btnWishlist.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("MovieWatchApp", MODE_PRIVATE);
            boolean isLoggedIn = prefs.getBoolean("isLoggedIn", false);

            if (isLoggedIn) {
                String oldTitles = prefs.getString("wishlist_titles", "");
                String oldImages = prefs.getString("wishlist_images", "");

                String currentTitle = movieTitle;
                String currentImage = String.valueOf(movieImage);

                boolean alreadyAdded = false;

                if (!oldTitles.isEmpty()) {
                    String[] titlesArray = oldTitles.split("\\|\\|");
                    for (String title : titlesArray) {
                        if (title.equals(currentTitle)) {
                            alreadyAdded = true;
                            break;
                        }
                    }
                }

                if (alreadyAdded) {
                    Toast.makeText(MovieDetailsActivity.this, "Already in Wishlist", Toast.LENGTH_SHORT).show();
                } else {
                    String newTitles = oldTitles.isEmpty() ? currentTitle : oldTitles + "||" + currentTitle;
                    String newImages = oldImages.isEmpty() ? currentImage : oldImages + "||" + currentImage;

                    prefs.edit()
                            .putString("wishlist_titles", newTitles)
                            .putString("wishlist_images", newImages)
                            .apply();

                    btnWishlist.setText("Added to Wishlist");
                    Toast.makeText(MovieDetailsActivity.this, "Added to Wishlist", Toast.LENGTH_SHORT).show();
                }

            } else {
                Intent intent = new Intent(MovieDetailsActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnSubmitReview.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("MovieWatchApp", MODE_PRIVATE);
            boolean isLoggedIn = prefs.getBoolean("isLoggedIn", false);

            if (!isLoggedIn) {
                Intent intent = new Intent(MovieDetailsActivity.this, LoginActivity.class);
                startActivity(intent);
                return;
            }

            String review = etReview.getText().toString().trim();
            float rating = ratingBar.getRating();

            if (review.isEmpty()) {
                Toast.makeText(MovieDetailsActivity.this, "Please write a review", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MovieDetailsActivity.this, "Review submitted: " + rating + " stars", Toast.LENGTH_SHORT).show();
            }
        });
    }
}