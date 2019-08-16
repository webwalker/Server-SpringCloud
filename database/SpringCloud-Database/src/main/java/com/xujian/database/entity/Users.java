package com.xujian.database.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class Users implements Serializable {
    private Integer id;

    @NotBlank(message = "用户名不能为空") //非空校验
    @Length(min = 2, max = 6, message = "最小长度为2位，最大长度为6位")
    private String name;
    @NotEmpty
    private String password;
    @Min(value = 15)
    private Integer age;
    @Email
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users [name=" + name + ", password=" + password + ", age=" + age + "]";
    }

}
