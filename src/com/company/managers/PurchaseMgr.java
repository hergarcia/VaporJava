package com.company.managers;

import com.company.objects.Game;
import com.company.objects.Purchase;
import com.company.objects.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class PurchaseMgr  {

    private static ArrayList<Purchase> store = new ArrayList<>();

    public static void create_new_purchase(User buyer, Game game, Double price) {
        Date date = new Date();
        Integer purchaseId = 1;
        ArrayList<Integer> purchaseIdList = new ArrayList<>();
        for (Purchase purchase : store) {
            purchaseIdList.add(purchase.getPurchaseId());
        }
        Collections.sort(purchaseIdList);
        for (Integer id : purchaseIdList) {
            if (purchaseId.equals(id)) {
                purchaseId ++;
            } else {
                break;
            }
        }
        Purchase purchase = new Purchase(buyer, game, price, date, purchaseId);
        store.add(purchase);
        UserMgr.addGameToLibrary(buyer.getUserId(), game.getGameId());
    }

    public static Purchase getPurchase (Integer purchaseId) {
        for (Purchase purchase : store) {
            if (purchase.getPurchaseId().equals(purchaseId)) {
                return purchase;
            }
        }
        return null;
    }

    public static void updatePurchase(User newBuyer, Game newGame, Double newPrice, Integer purchaseId) {
        Purchase purchase = getPurchase(purchaseId);
        assert purchase != null;
        Date date = new Date();
        purchase.setBuyer(newBuyer);
        purchase.setGame(newGame);
        purchase.setPrice(newPrice);
        purchase.setDate(date);
    }

    public static ArrayList<Purchase> storedPurchases() {
        return store;
    }
}
