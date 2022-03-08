package com.company.objects;

public class Admin extends User {


    public Admin(String username, String email, String password, Integer userId) {
        super(username, email, password, userId);
    }

    public boolean isAdmin() {
        return true;
    }
}
