package com.company;

import com.company.managers.CategoryMgr;
import com.company.managers.GameMgr;
import com.company.objects.Game;
import com.company.objects.Rating;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        CategoryMgr.createNewCategory("papa");
        Game j1 = GameMgr.createNewGame("RL1", "asd",19.99, 1);
        Game j2 = GameMgr.createNewGame("RL2", "asd",19.99, 1);
        Game j3 = GameMgr.createNewGame("RL3", "asd",19.99, 1);
        Game j4 = GameMgr.createNewGame("RL4", "asd",19.99, 1);

        ArrayList<Rating> rating1 = new ArrayList<>();
        ArrayList<Rating> rating2 = new ArrayList<>();
        ArrayList<Rating> rating3 = new ArrayList<>();
        ArrayList<Rating> rating4 = new ArrayList<>();
        Date date = new Date();
        Rating rat1 = new Rating(date, 3, 1);
        Rating rat2 = new Rating(date, 1, 2);
        Rating rat3 = new Rating(date, 2, 3);
        Rating rat4 = new Rating(date, 1, 4);
        Rating rat5 = new Rating(date, 4, 5);
        Rating rat6 = new Rating(date, 5, 6);
        Rating rat7 = new Rating(date, 5, 7);

        rating1.add(rat1);
        rating1.add(rat2);
        rating1.add(rat4);
        rating1.add(rat7);
        rating2.add(rat2);
        rating2.add(rat3);
        rating2.add(rat4);
        rating2.add(rat6);
        rating3.add(rat1);
        rating3.add(rat3);
        rating3.add(rat6);
        rating3.add(rat7);
        rating4.add(rat5);
        rating4.add(rat2);
        rating4.add(rat4);
        rating4.add(rat7);

        j1.setGameRatings(rating1);
        j2.setGameRatings(rating2);
        j3.setGameRatings(rating3);
        j4.setGameRatings(rating4);


        ArrayList<Game> ratingGame_list = new ArrayList<>();
        ratingGame_list.add(j3);
        ratingGame_list.add(j2);
        ratingGame_list.add(j1);
        ratingGame_list.add(j4);
        System.out.println(GameMgr.ratingFilter(2));
    }
}
