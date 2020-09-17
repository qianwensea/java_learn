package com.shi.java;

import org.junit.Test;

/**
 * @author 千文sea
 * @create 2020-03-31 18:47
 */
public class IDEADebugTest {
    @Test
    public void test1(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());// 4
        System.out.println(sb);// "null"
        StringBuffer sb1 = new StringBuffer(str); //抛异常NullPointerException
        System.out.println(sb1);//
    }
}
