package com.xujian.feign.server;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xujian on 2019-06-23
 */
@FeignClient(name = "github-server", url = "https://api.github.com")
public interface GitHubServerService {

    @RequestMapping(value = "/search/repositories", method = RequestMethod.GET)
    String searchRepositories(@RequestParam("q") String queryStr);
}
