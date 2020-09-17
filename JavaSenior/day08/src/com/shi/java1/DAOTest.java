package com.shi.java1;

import org.junit.Test;

/**
 * @author 千文sea
 * @create 2020-04-05 17:11
 */
public class DAOTest {
    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();
        dao1.add(new Customer());

        StudentDAO dao2 = new StudentDAO();
        dao2.add(new Student());
        Student index = dao2.getIndex(2);
    }
}
