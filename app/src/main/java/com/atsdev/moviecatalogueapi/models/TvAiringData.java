package com.atsdev.moviecatalogueapi.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import org.json.JSONObject;

public class TvAiringData implements Parcelable {
    private int voteCount;
    private int id;
    private Number voteAverage;
    private String name;
    private Number popularity;
    private String posterPath;
    private String originalLanguage;
    private String backdropPath;
    private String overview;
    private String firstAirDate;

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Number getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Number voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getPopularity() {
        return popularity;
    }

    public void setPopularity(Number popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public TvAiringData (JSONObject object) {
        try {
            this.voteCount = object.getInt("vote_count");
            this.id = object.getInt("id");
            this.voteAverage = (Number) object.get("vote_average");
            this.name = object.getString("name");
            this.popularity = (Number) object.get("popularity");
            String poster = object.getString("poster_path" );
            this.posterPath = "https://image.tmdb.org/t/p/w185/" + poster;
            this.originalLanguage = object.getString("original_language");
            String backdrop = object.getString("backdrop_path");
            this.backdropPath = "https://image.tmdb.org/t/p/w500/" + backdrop;
            this.overview = object.getString("overview");
            this.firstAirDate = object.getString("first_air_date");
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Error Data", e.getMessage());
        }
    }

    private TvAiringData(Parcel in) {
        this.voteCount = in.readInt();
        this.id = in.readInt();
        this.voteAverage = (Number) in.readSerializable();
        this.name = in.readString();
        this.popularity = (Number) in.readSerializable();
        this.posterPath = in.readString();
        this.originalLanguage = in.readString();
        this.backdropPath = in.readString();
        this.overview = in.readString();
        this.firstAirDate = in.readString();
    }

    public static final Creator<TvAiringData> CREATOR = new Creator<TvAiringData>() {
        @Override
        public TvAiringData createFromParcel(Parcel in) {
            return new TvAiringData(in);
        }

        @Override
        public TvAiringData[] newArray(int size) {
            return new TvAiringData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.voteCount);
        dest.writeInt(this.id);
        dest.writeSerializable(this.voteAverage);
        dest.writeString(this.name);
        dest.writeSerializable(this.popularity);
        dest.writeString(this.posterPath);
        dest.writeString(this.originalLanguage);
        dest.writeString(this.backdropPath);
        dest.writeString(this.overview);
        dest.writeString(this.firstAirDate);
    }
}
