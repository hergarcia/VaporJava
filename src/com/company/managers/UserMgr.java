package com.company.managers;

import com.company.objects.User;
import com.company.objects.Category;
import com.company.objects.User;

import java.util.ArrayList;

public class UserMgr {

    private static final ArrayList<User> STORE = new ArrayList<>();

    public static void create_new_user(String username, String email, String password, Integer user_id) {
        User user = new User(username, email, password, user_id);
        STORE.add(user);
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

}
