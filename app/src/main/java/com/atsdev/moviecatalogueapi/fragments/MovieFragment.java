package com.atsdev.moviecatalogueapi.fragments;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
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

import com.atsdev.moviecatalogueapi.R;
import com.atsdev.moviecatalogueapi.adapters.MovieAdapter;
import com.atsdev.moviecatalogueapi.adapters.MovieUpAdapter;
import com.atsdev.moviecatalogueapi.models.MovieData;
import com.atsdev.moviecatalogueapi.models.MovieUpData;
import com.atsdev.moviecatalogueapi.viewmodel.MovieUpViewModel;
import com.atsdev.moviecatalogueapi.viewmodel.MovieViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private MovieAdapter movieAdapter;
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
        MovieViewModel movieViewModel;
        MovieUpViewModel mvUpViewModel;

        recyclerView = view.findViewById(R.id.rv_movie);
        progressBar = view.findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);

        rvMovieUp = view.findViewById(R.id.rv_movie_up);
        progressBarUp = view.findViewById(R.id.progressbar_up);
        progressBarUp.setVisibility(View.VISIBLE);

        showRecycleCardView(view);
        showRecyclerMovieUp(view);

        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.setMovie();
        movieViewModel.getMovie().observe(this, getMovie);

        mvUpViewModel = ViewModelProviders.of(this).get(MovieUpViewModel.class);
        mvUpViewModel.setMovie();
        mvUpViewModel.getMovie().observe(this, getMovieUp);
    }

    private final Observer<ArrayList<MovieData>> getMovie = new Observer<ArrayList<MovieData>>() {
        @Override
        public void onChanged(@Nullable ArrayList<MovieData> movieData) {
            if (movieData != null) {
                movieAdapter.setMovieData(movieData);
                progressBar.setVisibility(View.GONE);
            }
        }
    };

    private final Observer<ArrayList<MovieUpData>> getMovieUp = new Observer<ArrayList<MovieUpData>>() {
        @Override
        public void onChanged(@Nullable ArrayList<MovieUpData> movieUpData) {
            if (movieUpData !=null) {
                movieUpAdapter.setMovieUpData(movieUpData);
                progressBarUp.setVisibility(View.GONE);
            }
        }
    };

    private void showRecycleCardView(View view) {
        movieAdapter = new MovieAdapter();
        movieAdapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, view.isInLayout()));
        recyclerView.setAdapter(movieAdapter);
    }

    private void showRecyclerMovieUp(View view) {
        movieUpAdapter = new MovieUpAdapter();
        movieUpAdapter.notifyDataSetChanged();
        rvMovieUp.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, view.isInLayout()));
        rvMovieUp.setAdapter(movieUpAdapter);
    }
}

