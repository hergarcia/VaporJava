package com.company.objects;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Game implements Comparable {

    private String title;
    private String description;
    private Double price;
    private Category category;
    private Double rating;
    private Integer game_id;
    private ArrayList<Review> game_reviews = new ArrayList<>();
    private ArrayList<Rating> game_ratings = new ArrayList<>();

    public Game(String title, String description, Double price, Category category, Double rating, Integer game_id) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.rating = rating;
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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
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

    public ArrayList<Rating> getGame_ratings() {
        return game_ratings;
    }

    public void setGame_ratings(ArrayList<Rating> game_ratings) {
        this.game_ratings = game_ratings;
    }

    @Override
    public String toString() {
        return "Game [title=" + title + ", description=" + description + ", price=" + price + ", category=" + category + ", rating=" + rating + "]";
    }

    @Override
    public int compareTo(@NotNull Object o) {
        Game otro = (Game) o;

        return this.getRating().compareTo(otro.getRating());
    }
}
