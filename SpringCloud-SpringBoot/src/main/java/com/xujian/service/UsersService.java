package com.xujian.service;

import com.xujian.pojo.Users;

import java.util.List;

public interface UsersService {

	void addUser(Users users);
	List<Users> findUserAll();
	Users findUserById(Integer id);
	void updateUser(Users users);
	void deleteUserById(Integer id);
} 
