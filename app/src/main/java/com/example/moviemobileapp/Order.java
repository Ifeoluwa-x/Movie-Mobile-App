package com.example.moviemobileapp;

import java.util.Date;

public class Order {
    private int id;
    private int userId;
    private String time;
    private int movieId;
    private int screeningId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }

    public Order() {
    }

    public Order(int id, int userId, String time, int movieId, int screeningId) {
        this.id = id;
        this.userId = userId;
        this.time = time;
        this.movieId = movieId;
        this.screeningId = screeningId;
    }
}