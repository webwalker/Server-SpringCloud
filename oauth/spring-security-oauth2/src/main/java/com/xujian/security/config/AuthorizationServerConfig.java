package com.xujian.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/*
* 在同时定义了认证服务器和资源服务器后，再去使用授权码模式获取令牌可能会遇到
* Full authentication is required to access this resource 的问题，
* 这时候只要确保认证服务器先于资源服务器配置即可，
* 比如在认证服务器的配置类上使用@Order(1)标注，在资源服务器的配置类上使用@Order(2)标注。
* */
@Order(1)
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
