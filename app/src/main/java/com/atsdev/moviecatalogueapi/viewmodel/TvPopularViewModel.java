package com.atsdev.moviecatalogueapi.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.atsdev.moviecatalogueapi.models.TvPopularData;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class TvPopularViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<TvPopularData>> listTvPopular = new MutableLiveData<>();

    public void setTvPopular() {
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<TvPopularData> listTvPopularItem = new ArrayList<>();
        String API_KEY = "Your themoviedb API key";
        String url = "https://api.themoviedb.org/3/tv/popular?api_key=" + API_KEY + "&language=en-US&page=1";

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result = new String(responseBody);
                try {
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray listTv = responseObject.getJSONArray("results");

                    for (int i = 0; i < listTv.length(); i++) {
                        JSONObject movie = listTv.getJSONObject(i);
                        TvPopularData tvPopularData = new TvPopularData(movie);
                        listTvPopularItem.add(tvPopularData);
                    }
                    listTvPopular.postValue(listTvPopularItem);
                } catch (Exception e) {
                    Log.d("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("Failure", error.getMessage());
            }
        });
    }

    public LiveData<ArrayList<TvPopularData>> getTvPopular() {
        return listTvPopular;
    }
}
