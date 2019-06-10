package com.xujian.eureka.controller;

import java.util.ArrayList;
import java.util.List;

import com.xujian.eureka.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/user")
	public List<User> getUsers(){
		List<User> list = new ArrayList<>();
		list.add(new User(1,"zhangsan",20));
		list.add(new User(2,"lisi",22));
		list.add(new User(3,"wangwu",20));
		return list;
	}
}
