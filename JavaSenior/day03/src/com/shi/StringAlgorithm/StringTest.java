package com.shi.StringAlgorithm;

import org.junit.Test;

/**
 * @author 千文sea
 * @create 2020-03-31 16:40
 */
public class StringTest {
    /*
        1. 模拟一个trim方法，去除字符串两端的空格。
     */
    public  String trim(String s){

        int l = 0,r = s.length() - 1;
        while (s.charAt(l) == ' '){
            l++;
        }
        while (s.charAt(r) == ' '){
            r--;
        }
        String s1 = "";
        if(l < r){
            s1 = s.substring(l,r+1);
        }
        return s1;
    }
    @Test
    public void test1(){
        String s = "  asd --sds dasd  ";
        System.out.println("---" + s + "---");
        System.out.println("---" + trim(s) + "---");
    }
    /*
        2. 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg"转为”abfedcg”
     */
    public  String reverse(String s,int start,int end){
        if(s == null)
            return null;
        String s1 = s.substring(start,end);
        StringBuffer sb = new StringBuffer(s1);
        String s2 = sb.reverse().toString();
        return s.replace(s1,s2);
    }
    @Test
    public void test2(){
        String s = "abcdefg";
        System.out.println(reverse(s,3,7));
    }
     /*   3. 获取一个字符串在另一个字符串中出现的次数。比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
     */

    /**
     * 获取subStr在mainStr中出现的次数
     * @param mainStr
     * @param subStr
     * @return
     */
     public int getCount(String mainStr,String subStr){
         int mainLength = mainStr.length();
         int subLength = subStr.length();
         int count = 0;
         int index = 0;
         if(mainLength >= subLength){
             //方式一:
//             while ((index = mainStr.indexOf(subStr)) != -1){
//                 count++;
//                 mainStr = mainStr.substring(index + subLength);
//             }
             //方式二:
             while ((index = mainStr.indexOf(subStr,index)) != -1){
                 count++;
                 index += subLength;
             }
         }
         return count;
     }
     @Test
    public void test3(){
            String mainStr = "abkkcadkabkebfkabkskab";
            String subStr = "ab";
         System.out.println(getCount(mainStr,subStr));
     }
     /*
            4.获取两个字符串中最大相同子串。比如：
            str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
            提示：将短的那个串进行长度依次递减的子串与较长的串比较。
      */
     //前提: 两个字符串中只有一个最大相同子串
     public String getMaxSameString(String str1,String str2){
         if(str1 != null&&str2 != null){
             String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
             String minStr = (str1.length() < str2.length()) ? str1 : str2;

             int length = minStr.length();
             for(int i = 0;i < length;i++){
                 for(int l = 0,r = length - i;r <= length;l++,r++){
                     String subStr = minStr.substring(l,r);
                     if(maxStr.contains(subStr)){
                         return subStr;
                     }
                 }
             }
         }
         return null;
     }
     @Test
    public void test4(){

         String str1 = "abcwerthelloyuiodef";
         String str2 = "cvhellobnm";
         System.out.println(getMaxSameString(str1,str2));
    }

     /*
            5.对字符串中字符进行自然顺序排序。
            提示：
            1）字符串变成字符数组。
            2）对数组排序，选择，冒泡，Arrays.sort();
            3）将排序后的数组变成字符串。
      */
    public void test5(){

     }

}
