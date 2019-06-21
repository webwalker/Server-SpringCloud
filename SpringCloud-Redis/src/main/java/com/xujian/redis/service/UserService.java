package com.xujian.redis.service;

import com.xujian.redis.pojo.User;

/**
 * Created by xujian on 2019-06-19
 */
public interface UserService {
    User getUser(int id);

    void deleteUser(int id);
}
