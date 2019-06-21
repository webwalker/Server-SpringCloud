package com.xujian.rabbitmq;

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

/**
 * 配置swagger
 *
 * @author tanjie
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 扫描该包下的所有需要在Swagger中展示的API，@ApiIgnore注解标注的除外
                .apis(RequestHandlerSelectors.basePackage("com.xujian.rabbitmq"))
                .paths(PathSelectors.any())
                .build();

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
                .version("1.0")
                .build();
    }
}
