package com.example.moviewatchapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviewatchapp.adapters.CategoryAdapter;
import com.example.moviewatchapp.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerCategories;
    private LinearLayout wishlistSection, profileSection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerCategories = findViewById(R.id.recyclerCategories);
        wishlistSection = findViewById(R.id.wishlistSection);
        profileSection = findViewById(R.id.profileSection);

        recyclerCategories.setLayoutManager(new GridLayoutManager(this, 2));

        List<CategoryModel> categoryList = new ArrayList<>();
        categoryList.add(new CategoryModel("Action", R.drawable.cat_action));
        categoryList.add(new CategoryModel("Comedy", R.drawable.cat_comedy));
        categoryList.add(new CategoryModel("Horror", R.drawable.cat_horror));
        categoryList.add(new CategoryModel("Drama", R.drawable.cat_drama));
        categoryList.add(new CategoryModel("Romance", R.drawable.cat_romance));
        categoryList.add(new CategoryModel("Sci-Fi", R.drawable.cat_scifi));

        CategoryAdapter adapter = new CategoryAdapter(categoryList);
        recyclerCategories.setAdapter(adapter);

        wishlistSection.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("MovieWatchApp", MODE_PRIVATE);
            boolean isLoggedIn = prefs.getBoolean("isLoggedIn", false);

            if (isLoggedIn) {
                Intent intent = new Intent(MainActivity.this, WishlistActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        profileSection.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("MovieWatchApp", MODE_PRIVATE);
            boolean isLoggedIn = prefs.getBoolean("isLoggedIn", false);

            if (isLoggedIn) {
                Toast.makeText(MainActivity.this, "You are already logged in", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}