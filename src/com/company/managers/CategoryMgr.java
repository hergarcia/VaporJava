package com.company.managers;

import com.company.objects.Category;

import java.util.ArrayList;

public class CategoryMgr {

    private static final ArrayList<Category> STORE = new ArrayList<>();

    public static void create_new_category(String cate_name) {
        Integer cate_id = STORE.size() + 1;
        Category category = new Category(cate_name, cate_id);
        STORE.add(category);
    }

    public static ArrayList<Category> getStore() {
        return STORE;
    }

    public static Category get_category(Integer cate_id) {
        for (Category cate : STORE) {
            if (cate.getCate_id().equals(cate_id)) {
                return cate;
            }
        }
        return null;
    }

    public static ArrayList<Category> stored_categories() {
        return STORE;
    }
}


