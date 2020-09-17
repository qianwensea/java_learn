package com.shi.dao;

import com.shi.domain.Role;

import java.util.List;

/**
 * @author 千文sea
 * @create 2020-09-15 16:19
 */
public interface IRoleDao {

    /**
     * 查找所有角色,
     * @return
     */
    List<Role> findAll();
}
