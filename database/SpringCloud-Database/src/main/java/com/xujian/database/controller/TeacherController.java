package com.xujian.database.controller;

import com.xujian.database.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    //http://localhost:8080/teacher?id=1
    //数据库造一条数据
    @RequestMapping(value = "/teacher")
    public String getTeacherMessage(String id) {
        return teacherService.queryTeacher(id).toString();
    }
}
