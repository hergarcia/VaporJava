package com.company.managers;

import com.company.objects.Review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class ReviewMgr {

    private static final ArrayList<Review> STORE = new ArrayList<>();

    public static Review create_new_review(String review_title, String text) {
        Date date = new Date();
        Integer review_id = 1;
        ArrayList<Integer> review_id_list = new ArrayList<>();

        for (Review review : STORE) {
            review_id_list.add(review.getReview_id());
        }
        Collections.sort(review_id_list);
        for (Integer id : review_id_list) {
            if (review_id.equals(id)) {
                review_id ++;
            } else {
                break;
            }
        }
        Review review = new Review(review_title, date, text, review_id);
        STORE.add(review);
        return review;
    }

    public static Review get_review (Integer review_id) {
        for (Review review : STORE) {
            if (review.getReview_id().equals(review_id)) {
                return review;
            }
        }
        return null;
    }

    public static void update_review(String new_review_title, String new_text, Integer review_id){
        Review review = get_review(review_id);
        assert review != null;
        Date date = new Date();
        review.setReview_title(new_review_title);
        review.setText(new_text);
        review.setDate(date);
    }

    public static ArrayList<Review> stored_reviews() {
        return STORE;
    }
}
