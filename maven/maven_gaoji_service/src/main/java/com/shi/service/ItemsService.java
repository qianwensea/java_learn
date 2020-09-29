package com.shi.service;

import com.shi.domain.Items;

/**
 * @author 千文sea
 * @create 2020-09-28 16:37
 */
public interface ItemsService {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Items findById(Integer id);
}
