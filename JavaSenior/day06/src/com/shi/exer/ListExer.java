package com.shi.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 千文sea
 * @create 2020-04-02 20:21
 */
public class ListExer {
    /*
        区分List中的两种remove()方法
     */
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }
    private static void updateList(List list) {
        list.remove(2);
    }
}
