package com.company.managers;

import com.company.objects.Category;

import java.util.ArrayList;
import java.util.Collections;

public class CategoryMgr {

    private static final ArrayList<Category> STORE = new ArrayList<>();

    public static void create_new_category(String cate_name) {
        Integer cate_id = 1;
        ArrayList<Integer> cate_id_list = new ArrayList<>();

        for (Category cate : STORE) {
            cate_id_list.add(cate.getCate_id());
        }
        Collections.sort(cate_id_list);
        for (Integer id : cate_id_list) {
            if (cate_id.equals(id)) {
                cate_id ++;
            } else {
                break;
            }
        }
        Category category = new Category(cate_name, cate_id);
        STORE.add(category);
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


