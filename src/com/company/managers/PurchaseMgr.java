package com.company.managers;

import com.company.objects.Client;
import com.company.objects.Game;
import com.company.objects.Purchase;
import com.company.objects.User;

import java.util.ArrayList;
import java.util.Date;

public class PurchaseMgr  {

    private static ArrayList<Purchase> store = new ArrayList<>();



    public static void create_new_purchase(User buyer, Game game, Double price, Integer purchase_id) {
        Date date = new Date();
        Purchase purchase = new Purchase(buyer, game, price, date, purchase_id);
        store.add(purchase);
        ClientMgr.add_game_to_library(buyer.getUser_id(), game.getGame_id());
    }
}
