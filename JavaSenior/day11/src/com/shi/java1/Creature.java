package com.shi.java1;

import java.io.Serializable;

/**
 * @author 千文sea
 * @create 2020-04-08 17:26
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }
    public void eat(){
        System.out.println("生物吃东西");
    }
}
