package com.company.managers;

import com.company.objects.Review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class ReviewMgr {

    private static ArrayList<Review> store = new ArrayList<>();

    public static Review createNewReview(String reviewTitle, String text) {
        Date date = new Date();
        Integer reviewId = 1;
        ArrayList<Integer> reviewIdList = new ArrayList<>();

        for (Review review : store) {
            reviewIdList.add(review.getReviewId());
        }
        Collections.sort(reviewIdList);
        for (Integer id : reviewIdList) {
            if (reviewId.equals(id)) {
                reviewId ++;
            } else {
                break;
            }
        }
        Review review = new Review(reviewTitle, date, text, reviewId);
        store.add(review);
        return review;
    }

    public static Review getReview (Integer reviewId) {
        for (Review review : store) {
            if (review.getReviewId().equals(reviewId)) {
                return review;
            }
        }
        return null;
    }

    public static void updateReview(String newReviewTitle, String newText, Integer reviewId){
        Review review = getReview(reviewId);
        assert review != null;
        Date date = new Date();
        review.setReviewTitle(newReviewTitle);
        review.setText(newText);
        review.setDate(date);
    }

    public static ArrayList<Review> storedReviews() {
        return store;
    }
}
