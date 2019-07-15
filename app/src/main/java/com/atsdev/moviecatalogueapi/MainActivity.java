package com.atsdev.moviecatalogueapi;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.atsdev.moviecatalogueapi.adapters.ViewPagerAdapter;
import com.atsdev.moviecatalogueapi.fragments.MovieFragment;
import com.atsdev.moviecatalogueapi.fragments.TvShowFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tablayout_id);
        ViewPager viewPager = findViewById(R.id.viewpager_id);

        String movie = getResources().getString(R.string.tab_movie);
        String tv_show = getResources().getString(R.string.tab_tvshow);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new MovieFragment(), movie);
        adapter.AddFragment(new TvShowFragment(), tv_show);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
