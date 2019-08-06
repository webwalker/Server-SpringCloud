package com.xujian.shiro;

import com.xujian.shiro.properties.SystemProperties;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 *
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(SystemProperties.class)
public class ShiroJWTApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ShiroJWTApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

}
