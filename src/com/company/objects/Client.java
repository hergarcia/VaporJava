package com.company.objects;

public class Client extends User {


    public Client(String username, String email, String password, Integer user_id) {
        super(username, email, password, user_id);
    }

    public boolean isAdmin() {
        return false;
    }
}
