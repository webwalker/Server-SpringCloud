package com.xujian.database.mapper;

import com.xujian.database.entity.Country;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by xujian on 2019-08-04
 */
@Mapper
public interface CountryMapper {

    @Select("select * from country;")
    List<Country> findAll();

}