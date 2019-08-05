package com.xujian.shiro.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Integer id;
    private String userName;
    private String password;
    private Date createTime;
    private String status;
}
