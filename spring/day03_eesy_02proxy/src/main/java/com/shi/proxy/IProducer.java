package com.shi.proxy;

/**
 * @author 千文sea
 * @create 2020-09-18 14:54
 *
 * 对生产厂家要求的接口
 */
public interface IProducer {
    /**
     * 销售
     * @param money
     */
    public void saleProduct(Float money);
    /**
     * 售后
     * @param money
     */
    public void afterService(Float money);
}
