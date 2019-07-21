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
    MovieUpData movieUpData;
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
        setContentView(R.layout.activity_detail_movie_upcoming);

        mvTitle = findViewById(R.id.tv_name);
        releaseDate = findViewById(R.id.tv_release);
        voteAverage = findViewById(R.id.tv_vote);
        tvPopularity = findViewById(R.id.tv_popularity);
        contentOverview = findViewById(R.id.tv_description);
        backdropPath = findViewById(R.id.blur_image);
        posterPath = findViewById(R.id.poster_image);

        movieUpData = getIntent().getParcelableExtra(EXTRA_MOVIE_UP);

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
