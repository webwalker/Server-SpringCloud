package com.xujian.utility.test;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xujian.utility.util.JsonUtil;

import java.util.Date;

public class Hero {
    @JsonIgnore //不会序列化到字符串中
    private Integer id;

    private String name;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthday;

    @JsonAlias({"fName", "f_name"})
    private String set;

    public static void main(String[] args) throws Exception {
        String json = JsonUtil.toJson(new Hero("Jason", new Date()));
        System.out.println(json);
        Hero hero = JsonUtil.fromJson(json, Hero.class);
        System.out.println(hero.name);
    }

    public Hero() {
    }

    public Hero(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }
}
