package com.company;

import com.company.objects.User;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void idSetter() {
        Integer setId = 1;
        ArrayList<Integer> id_list = new ArrayList<>();

        for (Object object : STORE) {
            id_list.add(object.getObject_id());
        }
        Collections.sort(id_list);
        for (Integer id : id_list) {
            if (setId.equals(id)) {
                setId ++;
            } else {
                break;
            }
        }
    }
}
