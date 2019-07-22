package com.xujian.apollo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 不需要监听配置变化，通过此类可获得最新的配置值
 */
@EnableApolloConfig(value = "application", order = 10)
@Component
@Slf4j
public class ApolloConfigs {
    @ApolloConfig
    private static Config config;

    public static String getConfig(String c) {
        return getConfig(new ConfigBean(c, "", ""));
    }

    public static String getConfig(ConfigBean cnf) {
        String value = null;
        if (cnf == null) {
            return value;
        }
        try {
            value = config.getProperty(cnf.getKey(), cnf.getDefaultValue());
            if (StringUtils.isBlank(value)) {
                log.warn("获取Apollo配置:{}为空", cnf.getKey());
            }
        } catch (Exception e) {
            log.error("获取Apollo配置异常", e);
        }
        return value;
    }
}
