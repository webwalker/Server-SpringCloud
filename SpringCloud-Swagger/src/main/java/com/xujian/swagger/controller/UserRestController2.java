package com.xujian.swagger.controller;

import com.xujian.swagger.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"UserRestController 1.0.2"})
@RestController
@RequestMapping(value = "/api102")
public class UserRestController2 {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping("/user")
    public boolean insert(@RequestBody User user) {
        logger.info("开始新增用户信息！请求参数:{}", user);
        return true;
    }

    @ApiOperation(value = "更新用户", notes = "根据User对象更新用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PutMapping("/user")
    public boolean update(@RequestBody User user) {
        logger.info("开始更新用户信息！请求参数:{}", user);
        return true;
    }

    @ApiOperation(value = "删除用户", notes = "根据User对象删除用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @DeleteMapping("/user")
    public boolean delete(@RequestBody User user) {
        logger.info("开始删除用户信息！请求参数:{}", user);
        return true;
    }

    /**
     * 注：@GetMapping("/user")是spring 4.3的新注解等价于：
     *
     * @param user
     * @return
     * @RequestMapping(value = "/user", method = RequestMethod.GET)
     */
    @ApiOperation(value = "获取用户列表", notes = "根据User对象查询用户信息")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @GetMapping("/user")
    public User findByUser(User user, int test) {
        logger.info("开始查询用户列表，请求参数:{}", user);
        User user2 = new User();
        user2.setId(1L);
        user2.setAge(18);
        user2.setName("xuwujing");
        return user2;
    }

}
