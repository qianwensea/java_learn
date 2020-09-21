package com.shi.cglib;

import com.shi.proxy.IProducer;

/**
 * @author 千文sea
 * @create 2020-09-18 14:50
 *
 * 一个生产者
 */
public class Producer {
    /**
     * 销售
     * @param money
     */
    public void saleProduct(Float money){
        System.out.println("销售商品,并拿到钱: " + money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(Float money){
        System.out.println("提供售后服务,并拿到钱: " + money);
    }
}
