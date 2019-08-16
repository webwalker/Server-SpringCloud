package com.xujian.database.service;

import com.xujian.database.entity.TeacherBean;
import com.xujian.database.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public TeacherBean queryTeacher(String id) {
        return teacherMapper.getTeacherById(id);
//        return new TeacherBean();
    }
}
