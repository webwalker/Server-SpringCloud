package com.xujian.shiro.dao;

import com.xujian.shiro.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {
	
	List<Role> findByUserName(String userName);
}
