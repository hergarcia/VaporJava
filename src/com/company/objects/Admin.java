package com.company.objects;

public class Admin extends User {


    public Admin(String username, String email, String password, Integer user_id) {
        super(username, email, password, user_id);
    }

    public boolean isAdmin() {
        return true;
    }
}
