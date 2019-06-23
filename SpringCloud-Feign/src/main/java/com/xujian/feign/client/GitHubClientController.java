package com.xujian.feign.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xujian on 2019-06-23
 */
@RestController
public class GitHubClientController {

    @Resource
    private GitHubClientService gitHubApiService;

    //http://localhost:8080/search/github/repository?name=spring
    @RequestMapping("/search/github/repository")
    public String searchGithubRepositoryByName(@RequestParam("name") String repositoryName) {
        return gitHubApiService.searchRepositories(repositoryName);
    }
}
