package com.xujian.service;

import java.util.List;

import com.xujian.mapper.UsersMapper;
import com.xujian.pojo.Users;
import com.xujian.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersMapper usersMapper;

	public void addUser(Users users) {
		this.usersMapper.insertUser(users);
	}

	public List<Users> findUserAll() {
		return this.usersMapper.selectUsersAll();
	}

	public Users findUserById(Integer id) {
		return this.usersMapper.selectUsersById(id);
	}

	public void updateUser(Users users) {
		this.usersMapper.updateUser(users);
	}

	public void deleteUserById(Integer id) {
		this.usersMapper.deleteUserById(id);
	}
}
