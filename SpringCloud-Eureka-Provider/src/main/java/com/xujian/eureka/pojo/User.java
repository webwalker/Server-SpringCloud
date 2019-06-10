package com.xujian.eureka.pojo;

public class User {
    private int userid;
    private String username;
    private int userage;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserage() {
        return userage;
    }

    public void setUserage(int userage) {
        this.userage = userage;
    }

    public User(int userid, String username, int userage) {
        super();
        this.userid = userid;
        this.username = username;
        this.userage = userage;
    }

    public User() {
        super();
    }

}
