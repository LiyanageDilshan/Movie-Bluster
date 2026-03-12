package com.example.moviewatchapp.models;

public class MovieModel {
    private int imageResId;
    private String title;

    public MovieModel(int imageResId, String title) {
        this.imageResId = imageResId;
        this.title = title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }
}