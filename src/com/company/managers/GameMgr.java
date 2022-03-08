package com.company.managers;

import com.company.objects.Category;
import com.company.objects.Game;
import com.company.objects.Rating;
import com.company.objects.Review;

import java.util.*;
import java.util.stream.Collectors;

public abstract class GameMgr implements Comparable<Game> {

    private static ArrayList<Game> store = new ArrayList<>();

    // Agrega un nuevo juego a la lista
    public static Game createNewGame(String title, String description, Double price, Integer categoryId) {

        Integer gameId = 1;
        ArrayList<Integer> gameIdList = new ArrayList<>();

        for (Game game : store) {
            gameIdList.add(game.getGameId());
        }
        Collections.sort(gameIdList);
        for (Integer id : gameIdList) {
            if (gameId.equals(id)) {
                gameId ++;
            } else {
                break;
            }
        }  // Encuentra id mas chico sin utilizar y lo asigna al nuevo juego

        Category category = CategoryMgr.getCategory(categoryId);
        Game game = new Game(title, description, price, category, 0.0, gameId);
        store.add(game);
        return game;
    }

    // Retorna el juego
    public static Game getGame(Integer gameId) {
        for (Game game : store) {
            if (game.getGameId().equals(gameId)) {
                return game;
            }
        }
        return null;
    }

    // Modifica atributos de un juego
    public static void updateGame(String newTitle, String newDescription, Double newPrice, Integer newCategoryId, Integer gameId) {
        Game game = getGame(gameId);
        Category cate = CategoryMgr.getCategory(newCategoryId);
        assert game != null;
        game.setTitle(newTitle);
        game.setDescription(newDescription);
        game.setPrice(newPrice);
        game.setCategory(cate);
    }

    // Retorna una lista con todos los juegos asociados a la categoria proporcionada
    public static ArrayList<Game> gameCategoryFilter(Integer categoryId) {
        ArrayList<Game> categoryGameList = new ArrayList<>();
        for (Game game : store) {
            if (game.getCategory().getCateId().equals(categoryId)) {
                categoryGameList.add(game);
            }
        }
        return categoryGameList;
    }

    // Elimina un juego
    public static void deleteGame(Integer gameId) {
        store.removeIf(game -> game.getGameId().equals(gameId));
    }

    // Retorna rating de un juego
    public static Double getGameRating(Integer gameId) {
        Game game = getGame(gameId);
        ArrayList<Integer> ratingValueList = new ArrayList<>();
        try {
            assert game != null;
            for (Rating rating : game.getGameRatings()) {
                ratingValueList.add(rating.getValue());
            }
            int n = 0;
            for (Integer value : ratingValueList) {
                n = n + value;
            }
            double mean;
            mean = (double) n / ratingValueList.size();
            return mean;

        } catch (Exception e) {
            return 0.0;
        }
    }

    // Crea rating de un juego
    public static void rateGame(Integer userId, Integer gameId, Integer value) {
        Game game = getGame(gameId);
        assert game != null;
        try {
            if (UserMgr.purchaseConfirm(userId, gameId)) {
                Rating rating = RatingMgr.createNewRating(value);
                game.getGameRatings().add(rating);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        game.setRating(getGameRating(game.getGameId()));

    }

    // Retorna lista de juegos con rating mayor al proporcionado, ordenados de mayor a menor
    public static ArrayList<Game> ratingFilter(Integer minRating) {
        ArrayList<Game> minRatingGameList = new ArrayList<>();
        for (Game game : store) {
            if (getGameRating(game.getGameId()) >= minRating) {
                minRatingGameList.add(game);
            }
        }
        List<Game> sortedFilter = minRatingGameList.stream().sorted(Comparator.comparingDouble(Game::getRating).reversed()).collect(Collectors.toList());
        return (ArrayList<Game>) sortedFilter;
    }

    // Crea review de un juego
    public static void reviewGame(Integer userId, Integer gameId, String reviewTitle, String text) {
        if (UserMgr.purchaseConfirm(userId, gameId)) {
            Review review = ReviewMgr.createNewReview(reviewTitle, text);
            getGame(gameId).getGameReviews().add(review);
        }
    }

    // Elimina review de juego
    public static void deleteGameReview(Integer gameId, Integer reviewId) {
        Game game = getGame(gameId);
        assert game != null;
        game.getGameReviews().removeIf(review -> review.getReviewId().equals(reviewId));
    }

    // Retorna las reviews de un juego
    public static ArrayList<Review> getReviews(Integer gameId) {
        Game game = getGame(gameId);
        assert game != null;
        return game.getGameReviews();
    }

    // Retorna la lista de juegos
    public static ArrayList<Game> storedGames() {
        return store;
    }

}
