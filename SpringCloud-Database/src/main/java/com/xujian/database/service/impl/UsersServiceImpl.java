package com.xujian.database.service.impl;

import com.xujian.database.entity.Users;
import com.xujian.database.mapper.UserMapper;
import com.xujian.database.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(Users users) {
        this.userMapper.insertUser(users);
//        int i = 4 / 0;
//        this.userMapper.insertUser(users);
    }

    @Override
    public List<Users> findUserAll() {
        return this.userMapper.selectUsersAll();
    }

    @Override
    public Users findUserById(Integer id) {
        return this.userMapper.selectUsersById(id);
    }

    @Override
    public void updateUser(Users users) {
        this.userMapper.updateUser(users);
        int i = 4 / 0;
        this.userMapper.updateUser(users);
    }

    @Override
    public void deleteUserById(Integer id) {
        this.userMapper.deleteUserById(id);
    }
}
