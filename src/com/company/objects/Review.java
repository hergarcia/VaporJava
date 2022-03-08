package com.company.objects;

import java.util.Date;

public class Review {

    private String reviewTitle;
    private Date date;
    private String text;
    private Integer reviewId;

    public Review(String reviewTitle, Date date, String text, Integer reviewId) {
        this.reviewTitle = reviewTitle;
        this.date = date;
        this.text = text;
        this.reviewId = reviewId;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }
}
