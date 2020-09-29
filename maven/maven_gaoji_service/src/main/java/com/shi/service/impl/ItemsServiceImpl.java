package com.shi.service.impl;

import com.shi.dao.ItemsDao;
import com.shi.domain.Items;
import com.shi.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 千文sea
 * @create 2020-09-28 16:37
 */
@Service(value = "itemsService")
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsDao itemsDao;

    @Override
    public Items findById(Integer id) {
        return itemsDao.findById(id);
    }

}
