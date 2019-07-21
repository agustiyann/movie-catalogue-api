package com.atsdev.moviecatalogueapi.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atsdev.moviecatalogueapi.R;
import com.atsdev.moviecatalogueapi.models.TvAiringData;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TvAirAdapter extends RecyclerView.Adapter<TvAirAdapter.CardViewViewHolder> {
    private final ArrayList<TvAiringData> tvAiringData = new ArrayList<>();

    public void setTvAirData(ArrayList<TvAiringData> itemData) {
        tvAiringData.clear();
        tvAiringData.addAll(itemData);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TvAirAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tv_airing, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvAirAdapter.CardViewViewHolder cardViewViewHolder, int i) {
        cardViewViewHolder.bind(tvAiringData.get(i));
    }

    @Override
    public int getItemCount() {
        return tvAiringData.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView titleTv;
        CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_tvairing);
            titleTv = itemView.findViewById(R.id.tv_item_tvair);
        }

        void bind(TvAiringData tvAiringData) {
            titleTv.setText(tvAiringData.getName());
            Glide.with(itemView).load(tvAiringData.getBackdropPath())
                    .into(imageView);
        }
    }
}
