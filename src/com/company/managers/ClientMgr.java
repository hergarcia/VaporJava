package com.company.managers;

import com.company.objects.Client;
import com.company.objects.Game;
import com.company.objects.Purchase;
import com.company.objects.User;

import java.util.ArrayList;

public class ClientMgr {

    private static final ArrayList<Client> STORE = new ArrayList<>();


    public static void create_new_client(String username, String email, String password, Integer user_id) {
        Client client = new Client(username, email, password, user_id);
        STORE.add(client);

    }
    public static ArrayList<Game>  get_purchased_games(Integer user_id) {
        for (User user : STORE) {
            if (user.getUser_id().equals(user_id)) {
                return user.getPurchased_games();
            }
        }
        return null;
    }

    public static void add_game_to_library(Integer user_id, Integer game_id) {
        try {
            if (purchase_confirm(user_id, game_id)) {
                for (User user : STORE) {
                    if (user.getUser_id().equals(user_id)) {
                        user.getPurchased_games().add(GameMgr.get_game(game_id));
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("Usuario no es propietario del juego");
        }
    }

    public static ArrayList<Game> purchased_games(Integer user_id) {
        for (User user : STORE) {
            if (user.getUser_id().equals(user_id)) {
                return user.getPurchased_games();
            }
        }
        return null;
    }
    public static boolean purchase_confirm(Integer user_id, Integer game_id) {
        for (Purchase purchase : PurchaseMgr.stored_purchases()) {
            if (purchase.getBuyer().equals(UserMgr.get_user(user_id)) && purchased_games(user_id).contains(GameMgr.get_game(game_id))) {
                return true;
            }
        }
        return false;
    }

}


