package com.xujian.config.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "web.pancm")//前缀  
public class MyProperties {
    /**
     * 获取个人标题
     */
    @Value("${title}")
    private String title;

    /**
     * 获取个人描述
     */
    @Value("${description}")
    private String description;

    /**
     * 获取获取个人标题
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置获取个人标题
     *
     * @param String title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取获取个人描述
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置获取个人描述
     *
     * @param String description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
