package com.xujian.feign.client;

import com.xujian.feign.entity.User;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

/**
 * Created by xujian on 2019-06-23
 */
@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface UserClientService {
    /**
     * RequestLine 注解：请求的方法与url，这里需要注意的是url写的是与Controller里的地址，不是完整的url地址。
     * GET 请求方法，遵循RESTful风格
     * @return
     */
    @RequestLine("GET /user/all")
    List<User> getAllUser();

    /**
     * restful方式传参
     * @param name
     * @return
     */
    @RequestLine("GET /user/{name}")
    User getByName(@Param("name") String name);

    /**
     * url方式传参数
     * @param id
     * @return
     */
    @RequestLine("GET /user/id?id={id}")
    User getById(@Param("id") String id);

    /**
     * post 传参，传复杂类型
     * @param user
     */
    @RequestLine("POST /user/add")
    void addUser(User user);

}