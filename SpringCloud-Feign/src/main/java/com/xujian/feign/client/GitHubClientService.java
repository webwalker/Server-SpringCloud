package com.xujian.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xujian on 2019-06-23
 */
@FeignClient(name = "github-client", url = "${feign.baseUrl}")
public interface GitHubClientService {

    @RequestMapping(value = "/searchMe", method = RequestMethod.GET)
    String searchRepositories(@RequestParam("q") String queryStr);
}
