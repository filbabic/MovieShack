package com.babic.filip.movieshack.model;

public class Movie {


    private String id;

    private String title;

    private String descriptio;

    private String rating;

    public Movie(String id, String title, String descriptio, String rating) {
        this.id = id;
        this.title = title;
        this.descriptio = descriptio;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescriptio() {
        return descriptio;
    }

    public String getRating() {
        return rating;
    }
}
