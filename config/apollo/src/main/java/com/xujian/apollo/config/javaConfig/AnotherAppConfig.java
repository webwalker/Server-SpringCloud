package com.xujian.apollo.config.javaConfig;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Configuration;

//注入多个namespace，不同的namespace相当于不同的配置文件
//相同的key名称, 以order小的配置为准
@Configuration
@EnableApolloConfig(value = {"TEST1.apollo", "application2.yml"}, order = 11)
public class AnotherAppConfig {
}
