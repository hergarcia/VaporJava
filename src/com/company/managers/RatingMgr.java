package com.company.managers;

import com.company.objects.Rating;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class RatingMgr {

    private static final ArrayList<Rating> STORE =new ArrayList<>();

    public static Rating create_new_rating(Integer value) {
        Date date = new Date();
        Integer rating_id = 1;
        ArrayList<Integer> rating_id_list = new ArrayList<>();

        for (Rating rating : STORE) {
            rating_id_list.add(rating.getRating_id());
        }
        Collections.sort(rating_id_list);
        for (Integer id : rating_id_list) {
            if (rating_id.equals(id)) {
                rating_id ++;
            } else {
                break;
            }
        }
        Rating rating = new Rating(date, value, rating_id);
        STORE.add(rating);
        return rating;
    }

    public static Rating get_rating (Integer rating_id) {
        for (Rating rating : STORE) {
            if (rating.getRating_id().equals(rating_id)) {
                return rating;
            }
        }
        return null;
    }

    public static void update_rating(Integer new_value, Integer rating_id){
        Rating rating = get_rating(rating_id);
        assert rating != null;
        Date date = new Date();
        rating.setValue(new_value);
        rating.setDate(date);
    }

    public static ArrayList<Rating> stored_ratings() {
        return STORE;
    }
}