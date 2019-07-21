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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie_popular);

        TextView mvTitle = findViewById(R.id.tv_name);
        TextView releaseDate = findViewById(R.id.tv_release);
        TextView voteAverage = findViewById(R.id.tv_vote);
        TextView tvPopularity = findViewById(R.id.tv_popularity);
        TextView contentOverview = findViewById(R.id.tv_description);
        ImageView backdropPath = findViewById(R.id.blur_image);
        ImageView posterPath = findViewById(R.id.poster_image);

        MoviePopularData moviePopularData = getIntent().getParcelableExtra(EXTRA_MOVIE);

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
