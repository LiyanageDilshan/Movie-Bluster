package com.example.moviewatchapp.database.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.example.moviewatchapp.database.entities.User;
@Entity(
        tableName = "wishlist",
        foreignKeys = @ForeignKey(
                entity = User.class,
                parentColumns = "id",
                childColumns = "userId",
                onDelete = ForeignKey.CASCADE
        )
)
public class Wishlist {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int userId;
    public String movieTitle;
    public int movieImage;

    public Wishlist(int userId, String movieTitle, int movieImage) {
        this.userId = userId;
        this.movieTitle = movieTitle;
        this.movieImage = movieImage;
    }
}
