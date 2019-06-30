package com.xujian.swagger.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SendUserRequest", description = "请求对应方法时使用")
public class SendUserRequest {

    private String id;

    @ApiModelProperty(value = "登录账户", required = true)
    @JsonProperty(required = true)
    private String email;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
