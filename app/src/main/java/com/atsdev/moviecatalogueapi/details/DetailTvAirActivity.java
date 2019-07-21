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
    TvAiringData tvAirData;
    TextView mvTitle;
    TextView releaseDate;
    TextView voteAverage;
    TextView tvPopularity;
    TextView contentOverview;
    ImageView backdropPath;
    ImageView posterPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_air);

        mvTitle = findViewById(R.id.tv_item_name);
        releaseDate = findViewById(R.id.tv_item_release);
        voteAverage = findViewById(R.id.tv_vote);
        tvPopularity = findViewById(R.id.tv_popularity);
        contentOverview = findViewById(R.id.tv_description);
        backdropPath = findViewById(R.id.blur_image);
        posterPath = findViewById(R.id.poster_image);

        tvAirData = getIntent().getParcelableExtra(EXTRA_TV);

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
