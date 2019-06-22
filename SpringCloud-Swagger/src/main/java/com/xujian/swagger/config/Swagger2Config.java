package com.xujian.swagger.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.Date;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.xujian.swagger";
    public static final String VERSION = "1.0.0";

    @Value("${swagger.enable}")
    private boolean enableSwagger;

    @Bean
    public Docket createRestApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 扫描该包下的所有需要在Swagger中展示的API，@ApiIgnore注解标注的除外
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .enable(enableSwagger)
                .directModelSubstitute(LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(Date.class, java.util.Date.class).apiInfo(apiInfo());

//        docket.useDefaultResponseMessages(false);
//        docket.globalResponseMessage(RequestMethod.GET, newArrayList(
//                new ResponseMessageBuilder()
//                        .code(500)
//                        .message("服务器发生异常")
//                        .responseModel(new ModelRef("Error"))
//                        .build(),
//                new ResponseMessageBuilder()
//                        .code(403)
//                        .message("资源不可用")
//                        .build()
//        ));

        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // API 标题
                .title("springboot-rabbitmq工程提供的Restful Api")
                // API描述
                .description("springboot-rabbitmq模块提供的Restful Api")
                // 联系人
                .contact(new Contact("xujian", "", "xujian.sh@qq.com"))
                // 版本号
                .version(VERSION)
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }
}
