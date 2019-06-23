package com.xujian.feign.client;

import com.xujian.feign.entity.User;
import feign.Feign;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xujian on 2019-06-23
 */
@Controller
public class UserClientController {

    @Value("${feign.baseUrl}")
    private static String apiBaseUrl = "http://localhost:8080/";

    UserClientService userApi = Feign.builder()
            .client(new ApacheHttpClient())
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .target(UserClientService.class, apiBaseUrl);

    //http://localhost:8080/client/user/xujian
    @GetMapping(value = "/client/user/{name}")
    @ResponseBody
    public User getUserInfo(@PathVariable String name){
        return userApi.getByName(name);
    }

}