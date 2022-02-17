package com.company.objects;

import java.util.Date;

public class Review {

    private String review_title;
    private Date date;
    private String text;
    private Integer review_id;

    public Review(String review_title, Date date, String text, Integer review_id) {
        this.review_title = review_title;
        this.date = date;
        this.text = text;
        this.review_id = review_id;
    }

    public String getReview_title() {
        return review_title;
    }

    public void setReview_title(String review_title) {
        this.review_title = review_title;
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

    public Integer getReview_id() {
        return review_id;
    }

    public void setReview_id(Integer review_id) {
        this.review_id = review_id;
    }
}
