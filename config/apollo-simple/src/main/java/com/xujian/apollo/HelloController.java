package com.xujian.apollo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/getValue")
    public String getKeyValue(@RequestParam("key") String key) {
        return ApolloConfigs.getConfig(key);
    }
}
