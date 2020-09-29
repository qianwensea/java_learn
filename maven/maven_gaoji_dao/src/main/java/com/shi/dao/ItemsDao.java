package com.shi.dao;

import com.shi.domain.Items;

/**
 * @author 千文sea
 * @create 2020-09-28 15:53
 */
public interface ItemsDao {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Items findById(Integer id);
}
