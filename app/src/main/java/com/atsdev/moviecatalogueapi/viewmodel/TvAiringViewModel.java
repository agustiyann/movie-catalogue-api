package com.atsdev.moviecatalogueapi.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.atsdev.moviecatalogueapi.models.TvAiringData;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class TvAiringViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<TvAiringData>> listTvAir = new MutableLiveData<>();

    public void setTvAir() {
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<TvAiringData> listTvAirItem = new ArrayList<>();
        String API_KEY = "Your themoviedb API key";
        String url = "https://api.themoviedb.org/3/tv/airing_today?api_key=" + API_KEY + "&language=en-US&page=1";

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result = new String(responseBody);
                try {
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray listTv = responseObject.getJSONArray("results");

                    for (int i = 0; i < listTv.length(); i++) {
                        JSONObject movie = listTv.getJSONObject(i);
                        TvAiringData tvAirData = new TvAiringData(movie);
                        listTvAirItem.add(tvAirData);
                    }
                    listTvAir.postValue(listTvAirItem);
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

    public LiveData<ArrayList<TvAiringData>> getTvAiring() {
        return listTvAir;
    }
}
