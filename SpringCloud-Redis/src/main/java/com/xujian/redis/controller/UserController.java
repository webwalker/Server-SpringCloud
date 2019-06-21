package com.xujian.redis.controller;

import com.xujian.redis.pojo.User;
import com.xujian.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xujian on 2019-06-19
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public User getUser() {
        User user = userService.getUser(1001);
        return user;
    }

    @RequestMapping("/deleteUser")
    public String deleteUser() {
        userService.deleteUser(1001);
        return "执行了删除";
    }
}
