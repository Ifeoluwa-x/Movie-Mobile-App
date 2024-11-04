package com.example.moviemobileapp;

public class Session {
    private int id;
    private int movie_id;
    private String time;
    private int screen_id;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getScreen_id() {
        return screen_id;
    }

    public void setScreen_id(int screen_id) {
        this.screen_id = screen_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Session() {
    }

    public Session(int id, int movie_id, String time, int screen_id, double price) {
        this.id = id;
        this.movie_id = movie_id;
        this.time = time;
        this.screen_id = screen_id;
        this.price = price;
    }
}