package com.xujian.feign.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xujian on 2019-06-23
 */
@RestController
public class GitHubController {
    @Autowired
    private GitHubServerService service;

    @RequestMapping(value = "/searchMe", method = RequestMethod.GET)
    public String searchRepositories(@RequestParam("q") String queryStr) {
        return service.searchRepositories(queryStr);
    }
}
