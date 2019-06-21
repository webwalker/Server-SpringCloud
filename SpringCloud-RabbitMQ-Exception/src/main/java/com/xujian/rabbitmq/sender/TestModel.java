package com.xujian.rabbitmq.sender;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by xujian on 2019-06-19
 */
@ApiModel("用户实体")
public class TestModel {
    @ApiModelProperty("用户 id")
    private int id;
}