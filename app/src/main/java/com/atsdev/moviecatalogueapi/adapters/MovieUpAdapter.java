package com.atsdev.moviecatalogueapi.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atsdev.moviecatalogueapi.R;
import com.atsdev.moviecatalogueapi.models.MovieUpData;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieUpAdapter extends RecyclerView.Adapter<MovieUpAdapter.CardViewViewHolder> {
    private final ArrayList<MovieUpData> movieUpData = new ArrayList<>();

    public void setMovieUpData(ArrayList<MovieUpData> itemData) {
        movieUpData.clear();
        movieUpData.addAll(itemData);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieUpAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie_upcoming, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieUpAdapter.CardViewViewHolder cardViewViewHolder, int i) {
        cardViewViewHolder.bind(movieUpData.get(i));
    }

    @Override
    public int getItemCount() {
        return movieUpData.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        final ImageView imgMovie;
        final TextView tvName;
        CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMovie = itemView.findViewById(R.id.imageUpView);
            tvName = itemView.findViewById(R.id.tv_item_up);
        }

        void bind(MovieUpData movieData) {
            tvName.setText(movieData.getTitle());
            Glide.with(itemView).load(movieData.getPosterPath())
                    .into(imgMovie);
        }
    }
}
