package com.atsdev.moviecatalogueapi.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.atsdev.moviecatalogueapi.R;
import com.atsdev.moviecatalogueapi.models.MovieUpData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class DetailMovieUpcomingActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE_UP = "extra_movie_up";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie_upcoming);

        TextView mvTitle = findViewById(R.id.tv_name);
        TextView releaseDate = findViewById(R.id.tv_release);
        TextView voteAverage = findViewById(R.id.tv_vote);
        TextView tvPopularity = findViewById(R.id.tv_popularity);
        TextView contentOverview = findViewById(R.id.tv_description);
        ImageView backdropPath = findViewById(R.id.blur_image);
        ImageView posterPath = findViewById(R.id.poster_image);

        MovieUpData movieUpData = getIntent().getParcelableExtra(EXTRA_MOVIE_UP);

        mvTitle.setText(movieUpData.getTitle());
        releaseDate.setText(movieUpData.getReleaseDate());
//        voteAverage.setText(String.valueOf(moviePopularData.getVoteAverage()));
        String voteNumber = movieUpData.getVoteAverage().toString();
        String percent = "/10";
        String voteValue =voteNumber + percent;
        voteAverage.setText(voteValue);
        tvPopularity.setText(String.valueOf(movieUpData.getPopularity()));
        contentOverview.setText(movieUpData.getOverview());
        Glide.with(this).load(movieUpData.getPosterPath())
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(10, 1)))
                .into(backdropPath);
        Glide.with(this).load(movieUpData.getPosterPath())
                .into(posterPath);
    }
}
