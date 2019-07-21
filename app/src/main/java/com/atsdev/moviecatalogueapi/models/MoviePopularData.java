package com.atsdev.moviecatalogueapi.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import org.json.JSONObject;

public class MoviePopularData implements Parcelable {
    private String title;
    private int voteCount;
    private String posterPath;
    private String overview;
    private String releaseDate;
    private String language;
    private Number voteAverage;
    private Number popularity;
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Number getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Number voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Number getPopularity() {
        return popularity;
    }

    public void setPopularity(Number popularity) {
        this.popularity = popularity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MoviePopularData(JSONObject object) {
        try {
            this.id = object.getInt("id");
            this.title = object.getString("title");
            this.overview = object.getString("overview");
            this.releaseDate = object.getString("release_date");
            this.language = object.getString("original_language");
            String poster= object.getString("poster_path" );
            this.posterPath = "https://image.tmdb.org/t/p/w185/" + poster;
            this.voteCount = object.getInt("vote_count");
            this.voteAverage = (Number) object.get("vote_average");
            this.popularity = (Number) object.get("popularity");
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Error Data", e.getMessage());
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeInt(this.voteCount);
        dest.writeString(this.posterPath);
        dest.writeString(this.overview);
        dest.writeString(this.releaseDate);
        dest.writeString(this.language);
        dest.writeSerializable(this.voteAverage);
        dest.writeSerializable(this.popularity);
        dest.writeInt(this.id);
    }

    private MoviePopularData(Parcel in) {
        this.title = in.readString();
        this.voteCount = in.readInt();
        this.posterPath = in.readString();
        this.overview = in.readString();
        this.releaseDate = in.readString();
        this.language = in.readString();
        this.voteAverage = (Number) in.readSerializable();
        this.popularity = (Number) in.readSerializable();
        this.id = in.readInt();
    }

    public static final Creator<MoviePopularData> CREATOR = new Creator<MoviePopularData>() {
        @Override
        public MoviePopularData createFromParcel(Parcel in) {
            return new MoviePopularData(in);
        }

        @Override
        public MoviePopularData[] newArray(int size) {
            return new MoviePopularData[size];
        }
    };
}
