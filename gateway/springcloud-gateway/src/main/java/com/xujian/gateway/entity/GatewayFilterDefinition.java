package com.xujian.gateway.entity;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 创建过滤器模型
 * Created by xujian on 2019-07-07
 */
@Data
public class GatewayFilterDefinition {
    //Filter Name
    private String name;
    //对应的路由规则
    private Map<String, String> args = new LinkedHashMap<>();
    //此处省略Get和Set方法
}