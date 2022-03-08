package com.company.managers;

import com.company.objects.Category;

import java.util.ArrayList;
import java.util.Collections;

public class CategoryMgr {

    private static ArrayList<Category> store = new ArrayList<>();

    public static void createNewCategory(String cateName) {
        Integer cateId = 1;
        ArrayList<Integer> cateIdList = new ArrayList<>();

        for (Category cate : store) {
            cateIdList.add(cate.getCateId());
        }
        Collections.sort(cateIdList);
        for (Integer id : cateIdList) {
            if (cateId.equals(id)) {
                cateId ++;
            } else {
                break;
            }
        }
        Category category = new Category(cateName, cateId);
        store.add(category);
    }

    public static Category getCategory(Integer cateId) {
        for (Category cate : store) {
            if (cate.getCateId().equals(cateId)) {
                return cate;
            }
        }
        return null;
    }

    public static ArrayList<Category> storedCategories() {
        return store;
    }
}


