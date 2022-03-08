package com.company.objects;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Game implements Comparable {

    private String title;
    private String description;
    private Double price;
    private Category category;
    private Double rating;
    private Integer gameId;
    private ArrayList<Review> gameReviews = new ArrayList<>();
    private ArrayList<Rating> gameRatings = new ArrayList<>();

    public Game(String title, String description, Double price, Category category, Double rating, Integer gameId) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.rating = rating;
        this.gameId = gameId;
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

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public ArrayList<Review> getGameReviews() {
        return gameReviews;
    }

    public void setGameReviews(ArrayList<Review> gameReviews) {
        this.gameReviews = gameReviews;
    }

    public ArrayList<Rating> getGameRatings() {
        return gameRatings;
    }

    public void setGameRatings(ArrayList<Rating> gameRatings) {
        this.gameRatings = gameRatings;
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
