package com.company.managers;

import com.company.objects.Game;
import com.company.objects.Purchase;
import com.company.objects.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class PurchaseMgr  {

    private static final ArrayList<Purchase> STORE = new ArrayList<>();

    public static void create_new_purchase(User buyer, Game game, Double price) {
        Date date = new Date();
        Integer purchase_id = 1;
        ArrayList<Integer> purchase_id_list = new ArrayList<>();
        for (Purchase purchase : STORE) {
            purchase_id_list.add(purchase.getPurchase_id());
        }
        Collections.sort(purchase_id_list);
        for (Integer id : purchase_id_list) {
            if (purchase_id.equals(id)) {
                purchase_id ++;
            } else {
                break;
            }
        }
        Purchase purchase = new Purchase(buyer, game, price, date, purchase_id);
        STORE.add(purchase);
        UserMgr.add_game_to_library(buyer.getUser_id(), game.getGame_id());
    }

    public static Purchase get_purchase (Integer purchase_id) {
        for (Purchase purchase : STORE) {
            if (purchase.getPurchase_id().equals(purchase_id)) {
                return purchase;
            }
        }
        return null;
    }

    public static void update_purchase(User new_buyer, Game new_game, Double new_price, Integer purchase_id) {
        Purchase purchase = get_purchase(purchase_id);
        assert purchase != null;
        Date date = new Date();
        purchase.setBuyer(new_buyer);
        purchase.setGame(new_game);
        purchase.setPrice(new_price);
        purchase.setDate(date);
    }

    public static ArrayList<Purchase> stored_purchases() {
        return STORE;
    }
}
