package com.example.moviemobileapp;

public class User {
    private int id;
    private String userNmae;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserNmae() {
        return userNmae;
    }

    public void setUserNmae(String userNmae) {
        this.userNmae = userNmae;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String password, String userNmae) {
        this.password = password;
        this.userNmae = userNmae;
    }

    public User(int id, String userNmae, String password) {
        this.id = id;
        this.userNmae = userNmae;
        this.password = password;
    }
}
