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
    TvPopularData tvPopularData;
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
        setContentView(R.layout.activity_detail_tv_popular);

        mvTitle = findViewById(R.id.tv_item_name);
        releaseDate = findViewById(R.id.tv_item_release);
        voteAverage = findViewById(R.id.tv_vote);
        tvPopularity = findViewById(R.id.tv_popularity);
        contentOverview = findViewById(R.id.tv_description);
        backdropPath = findViewById(R.id.blur_image);
        posterPath = findViewById(R.id.poster_image);

        tvPopularData = getIntent().getParcelableExtra(EXTRA_TV_POP);

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
