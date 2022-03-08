package com.company.objects;

public class Client extends User {


    public Client(String username, String email, String password, Integer userId) {
        super(username, email, password, userId);
    }

    public boolean isAdmin() {
        return false;
    }
}
