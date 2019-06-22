package com.xujian.elasticsearch.controller;

import com.xujian.elasticsearch.pojo.User;
import com.xujian.elasticsearch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserRestController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public boolean createUser(@RequestBody User user) {
        return userService.insert(user);
    }


    @GetMapping("/user/searchContent")
    public List<User> search(@RequestParam(value = "searchContent") String searchContent) {
        return userService.search(searchContent);
    }

    @GetMapping("/user")
    public List<User> searchUser(@RequestParam(value = "pageNumber") Integer pageNumber,
                                 @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                 @RequestParam(value = "searchContent") String searchContent) {
        return userService.searchUser(pageNumber, pageSize, searchContent);
    }


    @GetMapping("/user2")
    public List<User> searchUserByWeight(@RequestParam(value = "searchContent") String searchContent) {
        return userService.searchUserByWeight(searchContent);
    }

}
