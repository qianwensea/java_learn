package com.shi.dao;

import com.shi.domain.Items;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

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
