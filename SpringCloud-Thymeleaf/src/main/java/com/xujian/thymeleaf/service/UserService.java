package com.xujian.thymeleaf.service;

import com.xujian.thymeleaf.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    boolean updateUser(User user);


    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    boolean deleteUser(int id);

    /**
     * 根据用户名字查询用户信息
     *
     * @param userName
     */
    User findUserById(int id);

    /**
     * 查询所有
     *
     * @return
     */
    List<User> findAll();
}
