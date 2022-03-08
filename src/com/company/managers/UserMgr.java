package com.company.managers;

import com.company.objects.*;

import java.util.ArrayList;
import java.util.Collections;

public class UserMgr {

    private static ArrayList<User> store = new ArrayList<>();

    public static User getUser(Integer userId) {
        for (User user : store) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public static void createNewUser(String username, String email, String password) {
        Integer userId = 1;
        ArrayList<Integer> userIdList = new ArrayList<>();

        for (User user : store) {
            userIdList.add(user.getUserId());
        }
        Collections.sort(userIdList);
        for (Integer id : userIdList) {
            if (userId.equals(id)) {
                userId ++;
            } else {
                break;
            }
        }
        User user = new User(username, email, password, userId);
        store.add(user);
    }
    public static void createNewAdmin(String username, String email, String password) {
        Integer userId = 1;
        ArrayList<Integer> userIdList = new ArrayList<>();

        for (User user : store) {
            userIdList.add(user.getUserId());
        }
        Collections.sort(userIdList);
        for (Integer id : userIdList) {
            if (userId.equals(id)) {
                userId ++;
            } else {
                break;
            }
        }
        Admin admin = new Admin(username, email, password, userId);
        store.add(admin);
    }
    public static void createNewClient(String username, String email, String password) {
        Integer userId = 1;
        ArrayList<Integer> userIdList = new ArrayList<>();

        for (User user : store) {
            userIdList.add(user.getUserId());
        }
        Collections.sort(userIdList);
        for (Integer id : userIdList) {
            if (userId.equals(id)) {
                userId ++;
            } else {
                break;
            }
        }
        Client client = new Client(username, email, password, userId);
        store.add(client);
    }

    public static void updateUser(String newUsername, String newEmail, String newPassword, Integer userId) {
        User user = getUser(userId);
        assert user != null;
        user.setUsername(newUsername);
        user.setPassword(newPassword);
        user.setEmail(newEmail);


    }

    public static void deleteUser(Integer userId) {
        store.removeIf(user -> user.getUserId().equals(userId));
    }

    public static ArrayList<User> storedUsers() {
        return store;
    }

    public static void addGameToLibrary(Integer userId, Integer gameId) {
        if (purchaseConfirm(userId, gameId)) {
            for (User user : store) {
                if (user.getUserId().equals(userId)) {
                    user.getPurchasedGames().add(GameMgr.getGame(gameId));
                }
            }
        } else {
            System.out.println("Usuario no es propietario del juego");
        }
    }

    public static ArrayList<Game> purchasedGames(Integer userId) {
        User user = getUser(userId);
        assert user != null;
        if (user.getPurchasedGames().size() != 0){
            return user.getPurchasedGames();
        } else {
            return new ArrayList<>(0);
        }
    }

    public static boolean purchaseConfirm(Integer userId, Integer gameId) {
        for (Purchase purchase : PurchaseMgr.storedPurchases()) {
            if (purchase.getBuyer().equals(UserMgr.getUser(userId)) && purchasedGames(userId).contains(GameMgr.getGame(gameId))) {
                return true;
            }
        }
        return false;
    }

}
