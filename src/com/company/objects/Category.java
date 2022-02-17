package com.company.objects;

import java.util.ArrayList;

public class Category {

    private String cate_name;
    private Integer cate_id;

    public Category(String cate_name, Integer cate_id) {
        this.cate_name = cate_name;
        this.cate_id = cate_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public Integer getCate_id() {
        return cate_id;
    }

    public void setCate_id(Integer cate_id) {
        this.cate_id = cate_id;
    }


}
