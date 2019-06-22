package com.xujian.redis.dao.impl;

import com.alibaba.fastjson.JSON;
import com.xujian.redis.dao.UserDao;
import com.xujian.redis.pojo.User;
import com.xujian.redis.util.RedisUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private RedisUtil redisUtil;

    @Override
    public void addUser(User user) {
        redisUtil.set(String.valueOf(user.getId()), user.toString());
    }

    /**
     *
     */
    @Override
    public void updateUser(User user) {
        redisUtil.set(String.valueOf(user.getId()), user.toString());
    }

    /**
     *
     */
    @Override
    public void deleteUser(int id) {
        redisUtil.del(String.valueOf(id));
    }

    /**
     *
     */
    @Override
    public User findByUserId(int id) {
        String data = redisUtil.get(String.valueOf(id)).toString();
        User user = JSON.parseObject(data, User.class);
        return user;
    }
}
