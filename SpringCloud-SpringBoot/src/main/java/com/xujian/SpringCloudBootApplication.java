package com.xujian;

import com.xujian.filter.SecondFilter;
import com.xujian.listener.SecondListener;
import com.xujian.servlet.SecondServlet;
import com.xujian.upload.StorageProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ServletComponentScan //第一种方法, 启动时扫描web servlet的注解并进行实例化
//@EnableAutoConfiguration
@MapperScan("com.xujian.mapper") //@MapperScan 用户扫描MyBatis的Mapper接口
@EnableScheduling //SpringBoot默认的Scheduled定时任务、Quartz都使用
@EnableConfigurationProperties(StorageProperties.class)
@EnableAsync
public class SpringCloudBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudBootApplication.class, args);
    }

    /**
     * 第二种方法: 注册Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean getServletBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
        bean.addUrlMappings("/second");
        return bean;
    }

    /**
     * 第二种方法：注册Filter
     */
    @Bean
    public FilterRegistrationBean getFilterBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
        //bean.addUrlPatterns(new String[]{"*.do","*.jsp"});
        bean.addUrlPatterns("/second");
        return bean;
    }

    /**
     * 第二种方法：注册listener
     */
    @Bean
    public ServletListenerRegistrationBean<SecondListener> getListenerBean(){
        ServletListenerRegistrationBean<SecondListener> bean= new ServletListenerRegistrationBean<SecondListener>(new SecondListener());
        return bean;
    }
}
