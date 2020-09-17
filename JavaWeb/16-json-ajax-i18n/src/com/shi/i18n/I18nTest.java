package com.shi.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author 千文sea
 * @create 2020-09-08 9:56
 */
public class I18nTest {
    @Test
    public void testLocal(){
        //获取系统默认的语言,国家,时间
        Locale locale = Locale.getDefault();
        System.out.println(locale);
//        for (Locale local:Locale.getAvailableLocales()){
//            System.out.println(local);
//        }
        //获取中文的常量对象
        System.out.println(Locale.CHINA);
        //获取美式英文的常量对象
        System.out.println(Locale.US);
    }
    @Test
    public void testI18n(){
        //得到我们需要的local对象
        Locale locale = Locale.CHINA;

        // 通过指定的 basename 和 Locale 对象，读取 相应的配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);

        System.out.println("username：" + bundle.getString("username"));
        System.out.println("password：" + bundle.getString("password"));
        System.out.println("Sex：" + bundle.getString("sex"));
        System.out.println("age：" + bundle.getString("age"));
    }
}
