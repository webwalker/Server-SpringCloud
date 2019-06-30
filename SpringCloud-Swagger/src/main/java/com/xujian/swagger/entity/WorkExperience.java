package com.xujian.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "工作经验")
public class WorkExperience {
    @ApiModelProperty(value = "公司", required = true, example = "牛B的公司")
    private String company;
    private String role;
    private String start;
    private String end;

    public WorkExperience(String company, String role, String start, String end) {
        this.company = company;
        this.role = role;
        this.start = start;
        this.end = end;
    }

    public WorkExperience() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
