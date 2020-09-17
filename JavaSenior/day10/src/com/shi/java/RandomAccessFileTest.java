package com.shi.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**RandomAccessFile的使用:
 *
 * 1.RandomAccessFile 声明在java.io包下，但直接继承于java.lang.Object类。
 * 2.它实现了DataInput、DataOutput这两个接口，也就意味着这个类既可以读也可以写。
 * 3.如果RandomAccessFile作为输出流时,写出的文件不存在,则在执行过程中自动创建
 *      如果存在,则默认从头开始覆盖
 *
 * 4.RandomAccessFile 对象包含一个记录指针，用以标示当前读写处的位置。
 * RandomAccessFile 类对象可以自由移动记录指针：
 * long getFilePointer()：获取文件记录指针的当前位置
 * void seek(long pos)：将文件记录指针定位到 pos 位置
 *
 * 5.可以通过相关的操作,实现RandomAccessFile"插入"数据的效果
 *
 * @author 千文sea
 * @create 2020-04-07 16:52
 */
public class RandomAccessFileTest {
    @Test
    public void test1()  {
        //1.
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            //2.
            raf1 = new RandomAccessFile(new File("tupian.jpg"),"r");
            raf2 = new RandomAccessFile(new File("tupian1.jpg"),"rw");
            byte[] buff = new byte[1024];
            int len;
            //3.
            while ((len = raf1.read(buff)) != -1){
                raf2.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.
            try {
                if (raf2 != null)
                raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (raf1 != null)
                raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");
//        raf1.seek(3); //将指针调到角标为3的位置
        raf1.write("xyz".getBytes());
        raf1.close();
    }
    /*
    使用RandoAccessFile实现数据的插入效果
     */
    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");
        raf1.seek(3);
        //保存指针3后面的所有数据
        StringBuilder str = new StringBuilder((int) new File("hello.txt").length());
        byte[] buff = new byte[20];
        int len;
        while ((len = raf1.read(buff)) != -1){
            str.append(new String(buff,0,len));
        }
        //调回指针,写入"xyz"
        raf1.seek(3);
        raf1.write("xyz".getBytes());

        //将Str中的数据再写回到文件中
        raf1.write(str.toString().getBytes());
        //关闭流
        raf1.close();
    }
}
