package com.company.managers;

import com.company.objects.Review;

import java.util.ArrayList;
import java.util.Date;

public class ReviewMgr {

    private static final ArrayList<Review> STORE = new ArrayList<>();

    public static Review create_new_review(String review_title, String text) {
        Date date = new Date();
        Integer review_id = STORE.size() + 1;
        Review review = new Review(review_title, date, text, review_id);
        STORE.add(review);
        return review;
    }
}
