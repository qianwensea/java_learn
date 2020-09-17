package com.shi.java4;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional类: 为了在程序中避免出现空指针异常而创建的
 *
 * 常用的方法:
 *      ofNullable(T t)
 *      orELse(T t)
 *
 * @author 千文sea
 * @create 2020-04-10 14:33
 */
public class OptionalTest {

    /*
    创建Optional类对象的方法：
 Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
 Optional.empty() : 创建一个空的 Optional 实例
 Optional.ofNullable(T t)：t可以为null
     */
    @Test
    public void test1(){
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.of(girl);

    }
    @Test
    public void test2(){
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl); //Optional[Girl{name='null'}]
        girl = null;
        Optional<Girl> optionalGirl1 = Optional.ofNullable(girl);
        System.out.println(optionalGirl1); //Optional.empty

        //orElse(T t1): 如果当前optional内部封装的t是非空的,则返回内部的t.
        //如果内部的t是空的,则返回orElse()方法中的参数t1
        Girl girl1 = optionalGirl1.orElse(new Girl("Marry"));
        System.out.println(girl1); //Girl{name='Marry'}

    }

    public String getGirlName(Boy boy){

        return boy.getGirl().getName();
    }
    @Test
    public void test3(){
        Boy boy =  new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    //优化以后的getGirlName():
    public String getGirlName1(Boy boy){
        if (boy != null){
            Girl girl = boy.getGirl();
            if (girl != null)
                return boy.getGirl().getName();
        }
        return null;
    }
    @Test
    public void test4(){
        Boy boy =  new Boy();
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }
    //使用optional以后的getGirlName():
    public String getGirlName2(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("IU")));
        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        //此girl1一定非空
        Girl girl1 = girlOptional.orElse(new Girl("jenny"));
        return girl1.getName();
    }
    @Test
    public void test5(){
        Boy boy = null;
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }
}
