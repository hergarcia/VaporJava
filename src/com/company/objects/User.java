package com.company.objects;

import java.util.ArrayList;

public class User {

    protected String username;
    protected String email;
    protected String password;
    protected Integer userId;
    private ArrayList<Game> purchasedGames = new ArrayList<>();


    public User(String username, String email, String password, Integer userId) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userId = userId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public ArrayList<Game> getPurchasedGames() {
        return purchasedGames;
    }

    public void setPurchasedGames(ArrayList<Game> purchasedGames) {
        this.purchasedGames = purchasedGames;
    }

}