package com.example.moviewatchapp.database.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.example.moviewatchapp.database.entities.User;
@Entity(
        tableName = "reviews",
        foreignKeys = @ForeignKey(
                entity = User.class,
                parentColumns = "id",
                childColumns = "userId",
                onDelete = ForeignKey.CASCADE
        )
)
public class Review {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int userId;
    public String movieTitle;
    public float rating;
    public String reviewText;

    public Review(int userId, String movieTitle, float rating, String reviewText) {
        this.userId = userId;
        this.movieTitle = movieTitle;
        this.rating = rating;
        this.reviewText = reviewText;
    }
}