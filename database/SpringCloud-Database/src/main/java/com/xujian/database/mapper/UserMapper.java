package com.xujian.database.mapper;

import com.xujian.database.entity.Users;

import java.util.List;

public interface UserMapper {

	void insertUser(Users users);

	List<Users> selectUsersAll();

	Users selectUsersById(Integer id);

	void updateUser(Users users);

	void deleteUserById(Integer id);
}
