package com.shi.java;

import org.junit.Test;

/**
 * @author 千文sea
 * @create 2020-03-30 17:17
 */
public class StringMethodTest1 {
    /*
          boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
         boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
         boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始
         boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
         int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
         int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
         int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
         int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
        注：indexOf和lastIndexOf方法如果未找到都是返回-1
     */
    @Test
    public void test1(){
        String s1 = "helloworld";
        boolean b1 = s1.endsWith("ld");
        System.out.println(b1);
        boolean b2 = s1.startsWith("he");
        System.out.println(b2);

        boolean b3 = s1.startsWith("ll", 2);
        System.out.println(b3);

        String s2 = "wor";
        System.out.println(s1.contains(s2));

        System.out.println(s1.indexOf("lo"));
        System.out.println(s1.indexOf("lol"));
        System.out.println(s1.indexOf("lo",3));
        System.out.println(s1.indexOf("lo",4));

        String s3 = "hellorworld";
        System.out.println(s3.lastIndexOf("or"));
        System.out.println(s3.lastIndexOf("or",6));
    }
}
