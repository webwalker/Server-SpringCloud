package com.xujian.redis.service;

import com.xujian.redis.pojo.User;

/**
 * Created by xujian on 2019-06-19
 */
public interface UserService {
    User getUser(int id);

    /**
     * 新增用户
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    boolean updateUser(User user);


    /**
     * 删除用户
     * @param id
     * @return
     */
    boolean deleteUser(int id);


    /**
     * 查询所有
     * @return
     */
    User findByUserId(int id);
}
