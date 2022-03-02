package com.company.managers;

import com.company.objects.Category;
import com.company.objects.Game;
import com.company.objects.Rating;
import com.company.objects.Review;

import java.util.*;
import java.util.stream.Collectors;

public abstract class GameMgr implements Comparable<Game> {

    private static final ArrayList<Game> STORE = new ArrayList<>();

    // Agrega un nuevo juego a la lista
    public static Game create_new_game(String title, String description, Double price, Integer category_id) {

        Integer game_id = 1;
        ArrayList<Integer> game_id_list = new ArrayList<>();

        for (Game game : STORE) {
            game_id_list.add(game.getGame_id());
        }
        Collections.sort(game_id_list);
        for (Integer id : game_id_list) {
            if (game_id.equals(id)) {
                game_id ++;
            } else {
                break;
            }
        }  // Encuentra id mas chico sin utilizar y lo asigna al nuevo juego

        Category category = CategoryMgr.get_category(category_id);
        Game game = new Game(title, description, price, category, 0.0, game_id);
        STORE.add(game);
        return game;
    }

    // Retorna el juego
    public static Game get_game(Integer game_id) {
        for (Game game : STORE) {
            if (game.getGame_id().equals(game_id)) {
                return game;
            }
        }
        return null;
    }

    // Modifica atributos de un juego
    public static void update_game(String new_title, String new_description, Double new_price, Integer new_category_id, Integer game_id) {
        Game game = get_game(game_id);
        Category cate = CategoryMgr.get_category(new_category_id);
        assert game != null;
        game.setTitle(new_title);
        game.setDescription(new_description);
        game.setPrice(new_price);
        game.setCategory(cate);
    }

    // Retorna una lista con todos los juegos asociados a la categoria proporcionada
    public static ArrayList<Game> game_category_filter(Integer category_id) {
        ArrayList<Game> category_game_list = new ArrayList<>();
        for (Game game : STORE) {
            if (game.getCategory().getCate_id().equals(category_id)) {
                category_game_list.add(game);
            }
        }
        return category_game_list;
    }

    // Elimina un juego
    public static void delete_game(Integer game_id) {
        STORE.removeIf(game -> game.getGame_id().equals(game_id));
    }

    // Retorna rating de un juego
    public static Double get_game_rating(Integer game_id) {
        Game game = get_game(game_id);
        ArrayList<Integer> rating_value_list = new ArrayList<>();
        try {
            assert game != null;
            for (Rating rating : game.getGame_ratings()) {
                rating_value_list.add(rating.getValue());
            }
            int n = 0;
            for (Integer value : rating_value_list) {
                n = n + value;
            }
            double mean;
            mean = (double) n / rating_value_list.size();
            return mean;

        } catch (Exception e) {
            return 0.0;
        }
    }

    // Crea rating de un juego
    public static void rate_game(Integer user_id, Integer game_id, Integer value) {
        Game game = get_game(game_id);
        assert game != null;
        try {
            if (UserMgr.purchase_confirm(user_id, game_id)) {
                Rating rating = RatingMgr.create_new_rating(value);
                game.getGame_ratings().add(rating);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        game.setRating(get_game_rating(game.getGame_id()));

    }

    // Retorna lista de juegos con rating mayor al proporcionado, ordenados de mayor a menor
    public static ArrayList<Game> rating_filter(Integer min_rating) {
        ArrayList<Game> min_rating_game_list = new ArrayList<>();
        for (Game game : STORE) {
            if (get_game_rating(game.getGame_id()) >= min_rating) {
                min_rating_game_list.add(game);
            }
        }
        List<Game> sortedFilter = min_rating_game_list.stream().sorted(Comparator.comparingDouble(Game::getRating).reversed()).collect(Collectors.toList());
        return (ArrayList<Game>) sortedFilter;
    }

    // Crea review de un juego
    public static void review_game(Integer user_id, Integer game_id, String review_title, String text) {
        if (UserMgr.purchase_confirm(user_id, game_id)) {
            Review review = ReviewMgr.create_new_review(review_title, text);
            get_game(game_id).getGame_reviews().add(review);
        }
    }

    // Elimina review de juego
    public static void delete_game_review(Integer game_id, Integer review_id) {
        Game game = get_game(game_id);
        assert game != null;
        game.getGame_reviews().removeIf(review -> review.getReview_id().equals(review_id));
    }

    // Retorna las reviews de un juego
    public static ArrayList<Review> get_reviews(Integer game_id) {
        Game game = get_game(game_id);
        assert game != null;
        return game.getGame_reviews();
    }

    public static ArrayList<Game> stored_games() {
        return STORE;
    }

    public static void main(String[] args) {
        CategoryMgr.create_new_category("papa");
        Game j1 = create_new_game("RL1", "asd",19.99, 1);
        Game j2 = create_new_game("RL2", "asd",19.99, 1);
        Game j3 = create_new_game("RL3", "asd",19.99, 1);
        Game j4 = create_new_game("RL4", "asd",19.99, 1);

        ArrayList<Rating> rating1 = new ArrayList<>();
        ArrayList<Rating> rating2 = new ArrayList<>();
        ArrayList<Rating> rating3 = new ArrayList<>();
        ArrayList<Rating> rating4 = new ArrayList<>();
        Date date = new Date();
        Rating rat1 = new Rating(date, 3, 1);
        Rating rat2 = new Rating(date, 1, 2);
        Rating rat3 = new Rating(date, 2, 3);
        Rating rat4 = new Rating(date, 1, 4);
        Rating rat5 = new Rating(date, 4, 5);
        Rating rat6 = new Rating(date, 5, 6);
        Rating rat7 = new Rating(date, 5, 7);

        rating1.add(rat1);
        rating1.add(rat2);
        rating1.add(rat4);
        rating1.add(rat7);
        rating2.add(rat2);
        rating2.add(rat3);
        rating2.add(rat4);
        rating2.add(rat6);
        rating3.add(rat1);
        rating3.add(rat3);
        rating3.add(rat6);
        rating3.add(rat7);
        rating4.add(rat5);
        rating4.add(rat2);
        rating4.add(rat4);
        rating4.add(rat7);

        j1.setGame_ratings(rating1);
        j2.setGame_ratings(rating2);
        j3.setGame_ratings(rating3);
        j4.setGame_ratings(rating4);


        ArrayList<Game> rating_game_list = new ArrayList<>();
        rating_game_list.add(j3);
        rating_game_list.add(j2);
        rating_game_list.add(j1);
        rating_game_list.add(j4);
        System.out.println(rating_filter(2));
    }

}
