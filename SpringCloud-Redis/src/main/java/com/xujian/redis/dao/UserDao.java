package com.xujian.redis.dao;

import com.xujian.redis.pojo.User;

public interface UserDao {

    /**
     * 用户数据新增
     */
    void addUser(User user);

    /**
     * 用户数据修改
     */
    void updateUser(User user);

    /**
     * 用户数据删除
     */
    void deleteUser(int id);


    /**
     * 查询
     */
    User findByUserId(int id);

}
