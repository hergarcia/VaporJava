package com.company.objects;

import java.util.Date;

public class Rating {

    private Date date;
    private Integer value;
    private Integer ratingId;


    public Rating(Date date, Integer value, Integer ratingId) {
        this.date = date;
        this.value = value;
        this.ratingId = ratingId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }
}
