package com.xujian.database.service;

import com.xujian.database.entity.Users;

import java.util.List;

public interface UsersService {

	void addUser(Users users);
	List<Users> findUserAll();
	Users findUserById(Integer id);
	void updateUser(Users users);
	void deleteUserById(Integer id);
} 
