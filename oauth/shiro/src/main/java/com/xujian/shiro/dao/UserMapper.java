package com.xujian.shiro.dao;

import com.xujian.shiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	User findByUserName(String userName);
}
