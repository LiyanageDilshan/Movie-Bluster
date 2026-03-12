package com.example.moviewatchapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviewatchapp.adapters.WishlistAdapter;
import com.example.moviewatchapp.models.WishlistModel;

import java.util.ArrayList;
import java.util.List;

public class WishlistActivity extends AppCompatActivity {

    RecyclerView recyclerWishlist;
    TextView txtEmptyWishlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        recyclerWishlist = findViewById(R.id.recyclerWishlist);
        txtEmptyWishlist = findViewById(R.id.txtEmptyWishlist);

        recyclerWishlist.setLayoutManager(new GridLayoutManager(this, 2));

        SharedPreferences prefs = getSharedPreferences("MovieWatchApp", MODE_PRIVATE);

        String savedTitles = prefs.getString("wishlist_titles", "");
        String savedImages = prefs.getString("wishlist_images", "");

        List<WishlistModel> wishlist = new ArrayList<>();

        if (!savedTitles.isEmpty() && !savedImages.isEmpty()) {
            String[] titlesArray = savedTitles.split("\\|\\|");
            String[] imagesArray = savedImages.split("\\|\\|");

            for (int i = 0; i < titlesArray.length; i++) {
                if (i < imagesArray.length) {
                    int imageResId = Integer.parseInt(imagesArray[i]);
                    wishlist.add(new WishlistModel(titlesArray[i], imageResId));
                }
            }
        }

        if (wishlist.isEmpty()) {
            txtEmptyWishlist.setVisibility(TextView.VISIBLE);
        } else {
            txtEmptyWishlist.setVisibility(TextView.GONE);
        }

        WishlistAdapter adapter = new WishlistAdapter(wishlist);
        recyclerWishlist.setAdapter(adapter);
    }
}