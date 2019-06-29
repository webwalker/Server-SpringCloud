package com.xujian.oauth.core.controller;


import com.xujian.oauth.core.entity.Wrapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthorizeController {
    @Autowired
    private TokenStore tokenStore;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    //获取已认证的信息
    @PostMapping("/auth")
    public String auth(@RequestHeader("Authorization") String auth) {
        User user = (User) tokenStore.readAuthentication(auth.split(" ")[1]).getPrincipal();
        return user.getUsername() + ":" + user.getPassword();
    }

    @GetMapping(value = "/auth/user/refreshToken")
    @ApiOperation(httpMethod = "POST", value = "刷新token")
    public Wrapper<String> refreshToken(HttpServletRequest request, @RequestParam(value = "refreshToken") String refreshToken, @RequestParam(value = "accessToken") String accessToken) {
        return null;
    }
}
