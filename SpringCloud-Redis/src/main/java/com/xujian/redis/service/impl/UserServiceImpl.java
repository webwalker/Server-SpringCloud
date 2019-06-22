package com.xujian.redis.service.impl;

import com.xujian.redis.dao.UserDao;
import com.xujian.redis.pojo.User;
import com.xujian.redis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by xujian on 2019-06-19
 */
@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

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

    @Override
    public boolean addUser(User user) {
        boolean flag = false;
        try {
            userDao.addUser(user);
            flag = true;
        } catch (Exception e) {
            logger.error("新增失败!", e);
        }
        return flag;
    }

    @Override
    public boolean updateUser(User user) {
        boolean flag = false;
        try {
            userDao.updateUser(user);
            flag = true;
        } catch (Exception e) {
            logger.error("修改失败!", e);
        }
        return flag;
    }

    //    @CacheEvict(value = "users", key = "'user_'+#id", condition = "#id!=1")
    @Override
    public boolean deleteUser(int id) {
        boolean flag = false;
        try {
            userDao.deleteUser(id);
            flag = true;
        } catch (Exception e) {
            logger.error("删除失败!", e);
        }
        return flag;
    }


    @Override
    public User findByUserId(int id) {
        return userDao.findByUserId(id);
    }
}
