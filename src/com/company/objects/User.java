package com.company.objects;

import java.util.ArrayList;

public class User {

    protected String username;
    protected String email;
    protected String password;
    protected Integer user_id;

    private ArrayList<Game> purchased_games = new ArrayList<>();


    public User(String username, String email, String password, Integer user_id) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public ArrayList<Game> getPurchased_games() {
        return purchased_games;
    }

    public void setPurchased_games(ArrayList<Game> purchased_games) {
        this.purchased_games = purchased_games;
    }
}

