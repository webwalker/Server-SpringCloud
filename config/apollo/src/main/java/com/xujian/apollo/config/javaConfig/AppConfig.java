package com.xujian.apollo.config.javaConfig;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Configuration;

//注意@EnableApolloConfig要和@Configuration一起使用，不然不会生效。
//application是远程默认的namespace
@Configuration
@EnableApolloConfig(value = "application", order = 10)
public class AppConfig {
    //全局只需要一个地方配置此类就可以了
    //远程配置变化时会自动更新该类的关联属性
//    @Bean
//    public AnnotatedBean javaConfigBean() {
//        return new AnnotatedBean();
//    }

    //TestApolloAnnotationBean中定义@Configuration也可以
//    @Bean
//    public TestApolloAnnotationBean testApolloAnnotationBean() {
//        return new TestApolloAnnotationBean();
//    }
}
