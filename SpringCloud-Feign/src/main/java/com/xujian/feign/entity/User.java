package com.xujian.feign.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class User implements Serializable {
    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private String email;

    public User() {
    }

    public User(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
