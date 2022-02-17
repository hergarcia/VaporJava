package com.company.managers;

import com.company.objects.Client;
import com.company.objects.Game;
import com.company.objects.User;

import java.util.ArrayList;

public class ClientMgr {

    private static ArrayList<Client> store = new ArrayList<>();


    public static void create_new_client(String username, String email, String password, Integer user_id) {
        Client client = new Client(username, email, password, user_id);
        store.add(client);

    }
    public static ArrayList<Game>  get_purchased_games(Integer user_id) {
        for (User user : store) {
            if (user.getUser_id().equals(user_id)) {
                return user.getPurchased_games();
            }
        }
        return null;
    }

    public static void add_game_to_library(Integer user_id, Integer game_id) {
        for (User user : store) {
            if (user.getUser_id().equals(user_id)) {
                user.getPurchased_games().add(GameMgr.get_game(game_id));
            }
        }
    }

    public static ArrayList<Game> purchased_games (Integer user_id) {
        for (User user : store) {
            if (user.getUser_id().equals(user_id)) {
                return user.getPurchased_games();
            }
        }
        return null;
    }
}

