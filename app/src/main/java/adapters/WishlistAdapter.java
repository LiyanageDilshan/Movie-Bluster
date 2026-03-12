package com.example.moviewatchapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviewatchapp.R;
import com.example.moviewatchapp.models.WishlistModel;

import java.util.List;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.WishlistViewHolder> {

    private final List<WishlistModel> wishlist;

    public WishlistAdapter(List<WishlistModel> wishlist) {
        this.wishlist = wishlist;
    }

    @NonNull
    @Override
    public WishlistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wishlist, parent, false);
        return new WishlistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WishlistViewHolder holder, int position) {
        WishlistModel item = wishlist.get(position);
        holder.imgWishlistMovie.setImageResource(item.getImageResId());
        holder.txtWishlistTitle.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return wishlist.size();
    }

    static class WishlistViewHolder extends RecyclerView.ViewHolder {
        ImageView imgWishlistMovie;
        TextView txtWishlistTitle;

        public WishlistViewHolder(@NonNull View itemView) {
            super(itemView);
            imgWishlistMovie = itemView.findViewById(R.id.imgWishlistMovie);
            txtWishlistTitle = itemView.findViewById(R.id.txtWishlistTitle);
        }
    }
}