package com.shi.java;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * ObjectInputStream和OjbectOutputSteam
 *作用: 用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来
 *
 * 一个java对象要想是可序列化的,需要满足相应的条件.见Person类
 * 序列化机制:
 *ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 *
 * @author 千文sea
 * @create 2020-04-07 15:43
 */
public class ObjectTest {
    /*
    序列化过程: 将内存中的java对象保存到磁盘中或通过网络传输出去
    使用ObjecOutputStream实现
     */
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos = null;
        try {
            //1.
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            //2.
            oos.writeObject(new String("helloworld"));
            oos.flush();
            oos.writeObject(new Person("Tom",23)); //没有实现Serializable接口会出现NotSerializableException
            oos.flush();
            oos.writeObject(new Person("Jack",23,new Account(770)));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //3.
    }

    /*
    反序列化过程 : 将磁盘文件中的对象还原为内存中的一个java对象
     */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream oip = null;
        try {
            oip = new ObjectInputStream(new FileInputStream("object.dat"));

            Object object = oip.readObject();
            String str = (String)object;
            System.out.println(str);
            Object object1 = oip.readObject();
            Person p = (Person)object1;
            System.out.println(p);
            Object object2 = oip.readObject();
            Person p1 = (Person)object2;
            System.out.println(p1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oip != null)
                oip.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
