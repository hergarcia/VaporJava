package com.company.managers;

import com.company.objects.Rating;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class RatingMgr {

    private static ArrayList<Rating> store =new ArrayList<>();

    public static Rating createNewRating(Integer value) {
        Date date = new Date();
        Integer ratingId = 1;
        ArrayList<Integer> ratingIdList = new ArrayList<>();

        for (Rating rating : store) {
            ratingIdList.add(rating.getRatingId());
        }
        Collections.sort(ratingIdList);
        for (Integer id : ratingIdList) {
            if (ratingId.equals(id)) {
                ratingId ++;
            } else {
                break;
            }
        }
        Rating rating = new Rating(date, value, ratingId);
        store.add(rating);
        return rating;
    }

    public static Rating getRating (Integer ratingId) {
        for (Rating rating : store) {
            if (rating.getRatingId().equals(ratingId)) {
                return rating;
            }
        }
        return null;
    }

    public static void updateRating(Integer newValue, Integer ratingId){
        Rating rating = getRating(ratingId);
        assert rating != null;
        Date date = new Date();
        rating.setValue(newValue);
        rating.setDate(date);
    }

    public static ArrayList<Rating> storedRatings() {
        return store;
    }
}