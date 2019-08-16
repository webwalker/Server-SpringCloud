package com.xujian.database.mapper;

import com.xujian.database.entity.TeacherBean;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    /**
     * 通过id查询老师信息
     *
     * @param id id
     * @return teacher信息
     */
    TeacherBean getTeacherById(@Param("id") String id);
}
