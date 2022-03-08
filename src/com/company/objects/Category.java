package com.company.objects;

import java.util.ArrayList;

public class Category {

    private String cateName;
    private Integer cateId;

    public Category(String cateName, Integer cateId) {
        this.cateName = cateName;
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }


}
