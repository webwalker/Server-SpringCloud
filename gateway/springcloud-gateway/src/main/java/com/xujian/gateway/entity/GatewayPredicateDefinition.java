package com.xujian.gateway.entity;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 路由断言模型
 * Created by xujian on 2019-07-07
 */
@Data
public class GatewayPredicateDefinition {
    //断言对应的Name
    private String name;
    //配置的断言规则
    private Map<String, String> args = new LinkedHashMap<>();
    //此处省略Get和Set方法
}