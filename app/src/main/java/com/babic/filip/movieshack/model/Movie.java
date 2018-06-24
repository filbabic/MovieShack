package com.babic.filip.movieshack.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "movies")
public class Movie {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String id;

    private String title;

    @SerializedName("overview")
    private String description;

    @SerializedName("vote_count")
    private int numberOfVotes;

    @SerializedName("vote_average")
    private float averageScore;

    @SerializedName("poster_path")
    private String image;

    @SerializedName("release_date")
    private String releaseDate;

    private String popularity;

    @Nullable
    private String type; //this will be added post-fetching, to differentiate movie type

    public Movie(@NonNull final String id, final String title, final String description, final int numberOfVotes, final float averageScore, final String image,
                 final String releaseDate, final String popularity,
                 final String type) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.numberOfVotes = numberOfVotes;
        this.averageScore = averageScore;
        this.image = image;
        this.releaseDate = releaseDate;
        this.popularity = popularity;
        this.type = type;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull final String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(final int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    public float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(final float averageScore) {
        this.averageScore = averageScore;
    }

    public String getImage() {
        return image;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(final String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Nullable
    public String getType() {
        return type;
    }

    public void setType(@Nullable final String type) {
        this.type = type;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(final String popularity) {
        this.popularity = popularity;
    }
}
