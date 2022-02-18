package com.company.objects;

import java.util.ArrayList;

public class Game {

    private String title;
    private String description;
    private Double price;
    private Category category;
    private Integer game_id;
    private ArrayList<Review> game_reviews = new ArrayList<>();
    private ArrayList<Rating> game_rating = new ArrayList<>();

    public Game(String title, String description, Double price, Category category, Integer game_id) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.game_id = game_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public ArrayList<Review> getGame_reviews() {
        return game_reviews;
    }

    public void setGame_reviews(ArrayList<Review> game_reviews) {
        this.game_reviews = game_reviews;
    }

    public ArrayList<Rating> getGame_rating() {
        return game_rating;
    }

    public void setGame_rating(ArrayList<Rating> game_rating) {
        this.game_rating = game_rating;
    }
}
