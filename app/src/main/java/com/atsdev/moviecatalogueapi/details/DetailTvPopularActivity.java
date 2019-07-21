package com.atsdev.moviecatalogueapi.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.atsdev.moviecatalogueapi.R;
import com.atsdev.moviecatalogueapi.models.TvPopularData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class DetailTvPopularActivity extends AppCompatActivity {
    public static final String EXTRA_TV_POP = "extra_tv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_popular);

        TextView mvTitle = findViewById(R.id.tv_item_name);
        TextView releaseDate = findViewById(R.id.tv_item_release);
        TextView voteAverage = findViewById(R.id.tv_vote);
        TextView tvPopularity = findViewById(R.id.tv_popularity);
        TextView contentOverview = findViewById(R.id.tv_description);
        ImageView backdropPath = findViewById(R.id.blur_image);
        ImageView posterPath = findViewById(R.id.poster_image);

        TvPopularData tvPopularData = getIntent().getParcelableExtra(EXTRA_TV_POP);

        mvTitle.setText(tvPopularData.getName());
        releaseDate.setText(tvPopularData.getFirstAirDate());
//        voteAverage.setText(String.valueOf(moviePopularData.getVoteAverage()));
        String voteNumber = tvPopularData.getVoteAverage().toString();
        String percent = "/10";
        String voteValue =voteNumber + percent;
        voteAverage.setText(voteValue);
        tvPopularity.setText(String.valueOf(tvPopularData.getPopularity()));
        contentOverview.setText(tvPopularData.getOverview());
        Glide.with(this).load(tvPopularData.getPosterPath())
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(10, 1)))
                .into(backdropPath);
        Glide.with(this).load(tvPopularData.getPosterPath())
                .into(posterPath);
    }
}
