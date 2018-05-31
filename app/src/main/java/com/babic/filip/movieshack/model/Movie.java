package com.babic.filip.movieshack.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "movies")
public class Movie {

    @PrimaryKey
    private String id;

    private String title;
    private String description;
    private String rating;
    private String type; //this will be added post-fetching, to differentiate movie type

    public Movie(String id, String title, String description, String rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }
}
