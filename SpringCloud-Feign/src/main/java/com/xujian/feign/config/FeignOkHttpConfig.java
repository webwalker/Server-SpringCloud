package com.xujian.feign.config;

import feign.Feign;
import okhttp3.ConnectionPool;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by xujian on 2019-06-23
 */
@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class FeignOkHttpConfig {

    @Bean
    public okhttp3.OkHttpClient okHttpClient() {
        return new okhttp3.OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)   //设置连接超时
                .readTimeout(60, TimeUnit.SECONDS)      //设置读超时
                .writeTimeout(60, TimeUnit.SECONDS)     //设置写超时
                .retryOnConnectionFailure(true)                 //是否自动重连
                .connectionPool(new ConnectionPool())           //构建OkHttpClient对象
                .build();
    }
}