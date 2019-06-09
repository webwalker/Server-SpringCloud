package com.xujian.test;

import com.xujian.App;
import com.xujian.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SpringBoot 测试类
 *
 * @RunWith:启动器 SpringJUnit4ClassRunner.class:让 junit 与 spring 环境进行整合
 * @SpringBootTest(classes={App.class}) 1, 当前类为 springBoot 的测试类 *@SpringBootTest(classes={App.class}) 2,加载 SpringBoot 启动类。启动
 * springBoot *
 * junit 与 spring 整合 @Contextconfiguartion("classpath:applicationContext.xml")
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class UserServiceTest {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    public void testAddUser() {
        this.userServiceImpl.addUser();
    }
}