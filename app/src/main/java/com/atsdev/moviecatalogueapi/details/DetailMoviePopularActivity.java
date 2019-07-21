package com.atsdev.moviecatalogueapi.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.atsdev.moviecatalogueapi.R;
import com.atsdev.moviecatalogueapi.models.MoviePopularData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class DetailMoviePopularActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    MoviePopularData moviePopularData;
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
        setContentView(R.layout.activity_detail_movie_popular);

        mvTitle = findViewById(R.id.tv_movie_name);
        releaseDate = findViewById(R.id.tv_movie_release);
        voteAverage = findViewById(R.id.tv_vote_movieup);
        tvPopularity = findViewById(R.id.tv_popularity_movieup);
        contentOverview = findViewById(R.id.tv_movieup_description);
        backdropPath = findViewById(R.id.blur_image);
        posterPath = findViewById(R.id.poster_image);

        moviePopularData = getIntent().getParcelableExtra(EXTRA_MOVIE);

        mvTitle.setText(moviePopularData.getTitle());
        releaseDate.setText(moviePopularData.getReleaseDate());
//        voteAverage.setText(String.valueOf(moviePopularData.getVoteAverage()));
        String voteNumber = moviePopularData.getVoteAverage().toString();
        String percent = "/10";
        String voteValue =voteNumber + percent;
        voteAverage.setText(voteValue);
        tvPopularity.setText(String.valueOf(moviePopularData.getPopularity()));
        contentOverview.setText(moviePopularData.getOverview());
        Glide.with(this).load(moviePopularData.getPosterPath())
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(10, 1)))
                .into(backdropPath);
        Glide.with(this).load(moviePopularData.getPosterPath())
                .into(posterPath);
    }
}
