package com.xujian.redis.service.impl;

import com.xujian.redis.pojo.User;
import com.xujian.redis.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by xujian on 2019-06-19
 */
@Service
public class UserServiceImpl implements UserService {

    @Cacheable(value = "users", key = "'user_'+#id")
    @Override
    public User getUser(int id) {
        System.out.println(id + "进入实现类获取数据！");
        User user = new User();
        user.setId(id);
        user.setName("香菇");
        user.setAge(18);
        return user;
    }

    @CacheEvict(value = "users", key = "'user_'+#id", condition = "#id!=1")
    @Override
    public void deleteUser(int id) {
        System.out.println(id + "进入实现类删除数据！");
    }
}
