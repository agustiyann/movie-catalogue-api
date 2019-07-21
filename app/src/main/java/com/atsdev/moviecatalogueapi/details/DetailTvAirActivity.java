package com.atsdev.moviecatalogueapi.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.atsdev.moviecatalogueapi.R;
import com.atsdev.moviecatalogueapi.models.TvAiringData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class DetailTvAirActivity extends AppCompatActivity {
    public static final String EXTRA_TV = "extra_tv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_air);

        TextView mvTitle = findViewById(R.id.tv_item_name);
        TextView releaseDate = findViewById(R.id.tv_item_release);
        TextView voteAverage = findViewById(R.id.tv_vote);
        TextView tvPopularity = findViewById(R.id.tv_popularity);
        TextView contentOverview = findViewById(R.id.tv_description);
        ImageView backdropPath = findViewById(R.id.blur_image);
        ImageView posterPath = findViewById(R.id.poster_image);

        TvAiringData tvAirData = getIntent().getParcelableExtra(EXTRA_TV);

        mvTitle.setText(tvAirData.getName());
        releaseDate.setText(tvAirData.getFirstAirDate());
//        voteAverage.setText(String.valueOf(moviePopularData.getVoteAverage()));
        String voteNumber = tvAirData.getVoteAverage().toString();
        String percent = "/10";
        String voteValue =voteNumber + percent;
        voteAverage.setText(voteValue);
        tvPopularity.setText(String.valueOf(tvAirData.getPopularity()));
        contentOverview.setText(tvAirData.getOverview());
        Glide.with(this).load(tvAirData.getPosterPath())
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(10, 1)))
                .into(backdropPath);
        Glide.with(this).load(tvAirData.getPosterPath())
                .into(posterPath);
    }
}
