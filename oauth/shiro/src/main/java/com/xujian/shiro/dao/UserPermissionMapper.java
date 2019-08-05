package com.xujian.shiro.dao;

import com.xujian.shiro.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserPermissionMapper {
	
	List<Permission> findByUserName(String userName);
}
