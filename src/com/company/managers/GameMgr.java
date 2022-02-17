package com.company.managers;

import com.company.objects.Category;
import com.company.objects.Game;
import com.company.objects.Rating;
import com.company.objects.Review;


import java.util.ArrayList;
import java.util.Date;

public class GameMgr {

    private static ArrayList<Game> store = new ArrayList<>();


    //  Agrega un nuevo juego a la lista

    public static void create_new_game(String title, String description, Double price, Integer category_id) {
        Integer game_id = store.size() + 1;
        Category category = CategoryMgr.get_category(category_id);
        Game game = new Game(title, description, price, category, game_id);
        store.add(game);
    }

    //  Retorna el juego

    public static Game get_game(Integer game_id) {
        for (Game game : store) {
            if (game.getGame_id().equals(game_id)) {
                return game;
            }
        }
        return null;
    }

    // Modifica atributos de un juego

    public static void update_game(String new_title, String new_description, Double new_price, Integer new_category_id, Integer game_id) {
        for (Game game : store) {
            if (game.getGame_id().equals(game_id)) {
                game.setTitle(new_title);
                game.setDescription(new_description);
                game.setPrice(new_price);
                for (Category cate : CategoryMgr.stored_categories()) {
                    if (cate.getCate_id().equals(new_category_id)) {
                        game.setCategory(cate);
                    }
                }
            }
        }
    }
    //  Retorna todos los juegos asociados a esa categoria

    public static ArrayList<Game> game_category_filter(Integer category_id) {
        ArrayList<Game> category_game_list = new ArrayList<>();
        for (Game game : store) {
            if (game.getCategory().getCate_id().equals(category_id)) {
                category_game_list.add(game);
            }
        }
        return category_game_list;
    }

    //  Elimina un juego

    public static void delete_game(Integer game_id) {
        store.removeIf(game -> game.getGame_id().equals(game_id));
    }

    //  Retorna rating de un juego

    public static Double get_game_rating(Integer game_id) {
        ArrayList<Integer> value_rating_list = new ArrayList<>();
        for (Game game : store) {
            if (game.getGame_id().equals(game_id)) {
                for (Rating rating : game.getGame_rating()) {
                    value_rating_list.add(rating.getValue());
                }
            }
        }
        int n = 0;
        for (Integer value : value_rating_list) {
            n = n + value;
        }
        double promedio = 0.0;
        promedio = (double) n / value_rating_list.size();

        return promedio;
    }

    // Retorna lista de juegos con rating mayor al proporcionado

    public static ArrayList<Game> rating_filter(Integer min_rating) {
        ArrayList<Game> rating_game_list = new ArrayList<>();
        for (Game game : store) {
            if (get_game_rating(game.getGame_id()) >= min_rating) {
                rating_game_list.add(game);
            }
        }
        return rating_game_list;
    }
    //  Crea review de un juego

    public static void review_game(Integer game_id, String review_title, String text) {
        Integer review_id = get_game(game_id).getGame_reviews().size() + 1;
        Date date = new Date();
        Review review = new Review(review_title, date, text, review_id);
        for (Game game : store) {
            if (game.getGame_id().equals(game_id)) {
                game.getGame_reviews().add(review);
            }
        }
    }

    // Elimina review de juego

    public static void delete_game_review(Integer game_id, Integer review_id) {
        for (Game game : store) {
            if (game.getGame_id().equals(game_id)) {
                game.getGame_reviews().removeIf(review -> review.getReview_id().equals(review_id));
            }
        }
    }

    public static ArrayList<Review> get_reviews(Integer game_id) {
        for (Game game : store) {
            if (game.getGame_id().equals(game_id)) {
                return game.getGame_reviews();
            }
        }
        return null;
    }
    // Crea rating de un juego

    public static void rate_game(Integer game_id, Integer value) {
        Integer rating_id = get_game(game_id).getGame_rating().size() + 1;
        Date date = new Date();
        Rating rating = new Rating(date, value, rating_id);
        for (Game game : store) {
            if (game.getGame_id().equals(game_id)) {
                game.getGame_rating().add(rating);
            }
        }
    }
}
