package com.atsdev.moviecatalogueapi.fragments;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.atsdev.moviecatalogueapi.ItemClickSupport;
import com.atsdev.moviecatalogueapi.R;
import com.atsdev.moviecatalogueapi.adapters.MoviePopularAdapter;
import com.atsdev.moviecatalogueapi.adapters.MovieUpAdapter;
import com.atsdev.moviecatalogueapi.details.DetailMoviePopularActivity;
import com.atsdev.moviecatalogueapi.details.DetailMovieUpcomingActivity;
import com.atsdev.moviecatalogueapi.models.MoviePopularData;
import com.atsdev.moviecatalogueapi.models.MovieUpData;
import com.atsdev.moviecatalogueapi.viewmodel.MoviePopularViewModel;
import com.atsdev.moviecatalogueapi.viewmodel.MovieUpViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private MoviePopularAdapter moviePopularAdapter;
    private RecyclerView recyclerView;
    private RecyclerView rvMovieUp;
    private MovieUpAdapter movieUpAdapter;
    private ProgressBar progressBar;
    private ProgressBar progressBarUp;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MoviePopularViewModel moviePopularViewModel;
        MovieUpViewModel mvUpViewModel;

        recyclerView = view.findViewById(R.id.rv_movie);
        progressBar = view.findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);

        rvMovieUp = view.findViewById(R.id.rv_movie_up);
        progressBarUp = view.findViewById(R.id.progressbar_up);
        progressBarUp.setVisibility(View.VISIBLE);

        showRecycleCardView(view);
        showRecyclerMovieUp(view);

        moviePopularViewModel = ViewModelProviders.of(this).get(MoviePopularViewModel.class);
        moviePopularViewModel.setMovie();
        moviePopularViewModel.getMovie().observe(this, getMovie);

        mvUpViewModel = ViewModelProviders.of(this).get(MovieUpViewModel.class);
        mvUpViewModel.setMovie();
        mvUpViewModel.getMovie().observe(this, getMovieUp);
    }

    private final Observer<ArrayList<MoviePopularData>> getMovie = new Observer<ArrayList<MoviePopularData>>() {
        @Override
        public void onChanged(ArrayList<MoviePopularData> moviePopularData) {
            if (moviePopularData != null) {
                moviePopularAdapter.setMovieData(moviePopularData);
                progressBar.setVisibility(View.GONE);
                ItemClickSupport.addTo(recyclerView).setOnItemClickListener((recyclerView, position, v) ->
                        showSelectedPopularData(moviePopularData.get(position)));
            }
        }
    };

    private final Observer<ArrayList<MovieUpData>> getMovieUp = new Observer<ArrayList<MovieUpData>>() {
        @Override
        public void onChanged(ArrayList<MovieUpData> movieUpData) {
            if (movieUpData !=null) {
                movieUpAdapter.setMovieUpData(movieUpData);
                progressBarUp.setVisibility(View.GONE);
                ItemClickSupport.addTo(rvMovieUp).setOnItemClickListener((rvMovieUp, position, v) ->
                        showSelectedUpcomingData(movieUpData.get(position)));
            }
        }
    };

    private void showSelectedPopularData(MoviePopularData itemPopularData) {
        Intent intent = new Intent(getActivity(), DetailMoviePopularActivity.class);
        intent.putExtra(DetailMoviePopularActivity.EXTRA_MOVIE, itemPopularData);
        startActivity(intent);
    }

    private void showSelectedUpcomingData(MovieUpData itemUpData) {
        Intent upIntent = new Intent(getActivity(), DetailMovieUpcomingActivity.class);
        upIntent.putExtra(DetailMovieUpcomingActivity.EXTRA_MOVIE_UP, itemUpData);
        startActivity(upIntent);
    }

    private void showRecycleCardView(View view) {
        moviePopularAdapter = new MoviePopularAdapter();
        moviePopularAdapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, view.isInLayout()));
        recyclerView.setAdapter(moviePopularAdapter);
    }

    private void showRecyclerMovieUp(View view) {
        movieUpAdapter = new MovieUpAdapter();
        movieUpAdapter.notifyDataSetChanged();
        rvMovieUp.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, view.isInLayout()));
        rvMovieUp.setAdapter(movieUpAdapter);
    }
}

