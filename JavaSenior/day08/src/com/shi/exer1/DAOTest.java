package com.shi.exer1;

import java.util.List;

/**
 *
 * 定义一个测试类：
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方
 * 法来操作 User 对象，
 * 使用 Junit 单元测试类进行测试。
 *
 * @author 千文sea
 * @create 2020-04-05 20:33
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> user = new DAO<User>();
        user.save("1001",new User(1001,33,"Tom"));
        user.save("1002",new User(1002,23,"Jack"));
        user.save("1003",new User(1003,43,"Mary"));
        user.update("1003",new User(1004,12,"kk"));
        List<User> list = user.list();
        System.out.println(list);
        list.forEach(System.out::println);
    }
}
