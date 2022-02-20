package com.company.managers;

import com.company.objects.Admin;
import com.company.objects.Client;
import com.company.objects.User;

import java.util.ArrayList;

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
        Integer user_id = STORE.size() + 1;
        User user = new User(username, email, password, user_id);
        STORE.add(user);
    }
    public static void create_new_admin(String username, String email, String password) {
        Integer user_id = STORE.size() + 1;
        Admin admin = new Admin(username, email, password, user_id);
        STORE.add(admin);
    }
    public static void create_new_client(String username, String email, String password) {
        Integer user_id = STORE.size() + 1;
        Client client = new Client(username, email, password, user_id);
        STORE.add(client);
    }

    public static void update_user(String new_username, String new_email, String new_password, Integer user_id) {
        for (User user : STORE) {
            if (user.getUser_id().equals(user_id)) {
                user.setUsername(new_username);
                user.setPassword(new_password);
                user.setEmail(new_email);
            }
        }
    }

    public static void delete_user(Integer user_id) {
        STORE.removeIf(user -> user.getUser_id().equals(user_id));
    }

    public static ArrayList<User> stored_users() {
        return STORE;
    }

}
