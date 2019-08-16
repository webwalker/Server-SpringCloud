package com.xujian.database;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@MapperScan("com.xujian.database.mapper")
public class DataBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataBaseApplication.class, args);
    }

    //一般不需要, 除非是有两套持久化依赖(JPA、JDBC)
    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
