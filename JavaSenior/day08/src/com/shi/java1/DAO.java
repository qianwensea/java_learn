package com.shi.java1;

import java.util.List;

/**
 * @author 千文sea
 * @create 2020-04-05 17:03
 *
 * DAO: data(base) access object 数据访问对象
 */
public class DAO<T> { //表的共性操作的DAO
    //添加一条记录
    public void add(T t){};
    //删除一条记录
    public boolean remove(int index){
        return true;
    }
    //修改一条记录
    public void updata(int index,T t){

    }
    //查询一条记录
    public T getIndex(int index){
        return null;
    }
    //查询多条记录
    public List<T> getForList(int index){
        return null;
    }

    //泛型方法
    public <E> E getValue(){
        return null;
    }
}
