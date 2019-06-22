package com.xujian.thymeleaf.dao;

import com.xujian.thymeleaf.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Insert("insert into t_user(id,name,password,age) values (#{id},#{name},#{password},#{age})")
    void addUser(User user);

    @Update("update t_user set name=#{name},password=#{password}, age=#{age} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from t_user where id=#{id}")
    void deleteUser(int id);

    @Select("SELECT * FROM t_user where id=#{id}")
    User findById(int id);


    @Select("SELECT * FROM t_user")
    List<User> findAll();
}
