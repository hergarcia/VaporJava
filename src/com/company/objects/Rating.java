package com.company.objects;

import java.util.Date;

public class Rating {

    private Date date;
    private Integer value;
    private Integer rating_id;


    public Rating(Date date, Integer value, Integer rating_id) {
        this.date = date;
        this.value = value;
        this.rating_id = rating_id;
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

    public Integer getRating_id() {
        return rating_id;
    }

    public void setRating_id(Integer rating_id) {
        this.rating_id = rating_id;
    }
}
