package com.company.managers;

import com.company.objects.Rating;

import java.util.ArrayList;
import java.util.Date;

public class RatingMgr {

    private static final ArrayList<Rating> STORE =new ArrayList<>();

    public static Rating create_new_rating(Integer value) {
        Date date = new Date();
        Integer rating_id = STORE.size() + 1;
        Rating rating = new Rating(date, value, rating_id);
        STORE.add(rating);
        return rating;
    }
}