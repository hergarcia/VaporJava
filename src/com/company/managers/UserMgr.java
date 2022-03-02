package com.company.managers;

import com.company.objects.*;

import java.util.ArrayList;
import java.util.Collections;

public class UserMgr {

    private static final ArrayList<User> STORE = new ArrayList<>();

    public static User get_user(Integer user_id) {
        for (User user : STORE) {
            if (user.getUser_id().equals(user_id)) {
                return user;
            }
        }
        return null;
    }

    public static void create_new_user(String username, String email, String password) {
        Integer user_id = 1;
        ArrayList<Integer> user_id_list = new ArrayList<>();

        for (User user : STORE) {
            user_id_list.add(user.getUser_id());
        }
        Collections.sort(user_id_list);
        for (Integer id : user_id_list) {
            if (user_id.equals(id)) {
                user_id ++;
            } else {
                break;
            }
        }
        User user = new User(username, email, password, user_id);
        STORE.add(user);
    }
    public static void create_new_admin(String username, String email, String password) {
        Integer user_id = 1;
        ArrayList<Integer> user_id_list = new ArrayList<>();

        for (User user : STORE) {
            user_id_list.add(user.getUser_id());
        }
        Collections.sort(user_id_list);
        for (Integer id : user_id_list) {
            if (user_id.equals(id)) {
                user_id ++;
            } else {
                break;
            }
        }
        Admin admin = new Admin(username, email, password, user_id);
        STORE.add(admin);
    }
    public static void create_new_client(String username, String email, String password) {
        Integer user_id = 1;
        ArrayList<Integer> user_id_list = new ArrayList<>();

        for (User user : STORE) {
            user_id_list.add(user.getUser_id());
        }
        Collections.sort(user_id_list);
        for (Integer id : user_id_list) {
            if (user_id.equals(id)) {
                user_id ++;
            } else {
                break;
            }
        }
        Client client = new Client(username, email, password, user_id);
        STORE.add(client);
    }

    public static void update_user(String new_username, String new_email, String new_password, Integer user_id) {
        User user = get_user(user_id);
        assert user != null;
        user.setUsername(new_username);
        user.setPassword(new_password);
        user.setEmail(new_email);


    }

    public static void delete_user(Integer user_id) {
        STORE.removeIf(user -> user.getUser_id().equals(user_id));
    }

    public static ArrayList<User> stored_users() {
        return STORE;
    }

    public static void add_game_to_library(Integer user_id, Integer game_id) {
        if (purchase_confirm(user_id, game_id)) {
            for (User user : STORE) {
                if (user.getUser_id().equals(user_id)) {
                    user.getPurchased_games().add(GameMgr.get_game(game_id));
                }
            }
        } else {
            System.out.println("Usuario no es propietario del juego");
        }
    }

    public static ArrayList<Game> purchased_games(Integer user_id) {
        User user = get_user(user_id);
        assert user != null;
        if (user.getPurchased_games().size() != 0){
            return user.getPurchased_games();
        } else {
            return new ArrayList<>(0);
        }
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
