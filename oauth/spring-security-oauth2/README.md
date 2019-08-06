参考：
Spring Security OAuth2入门：https://mrbird.cc/Spring-Security-OAuth2-Guide.html
Spring Security OAuth2自定义Token获取方式：https://mrbird.cc/Spring-Security-OAuth2-Customize.html
Spring Security OAuth2自定义令牌配置：https://mrbird.cc/Spring-Security-OAuth2-Token-Config.html
Spring Security OAuth2单点登录：https://mrbird.cc/Spring-Security-OAuth2-SSO.html

获得授权码：

http://localhost:8080/oauth/authorize?response_type=code&client_id=test&scope=all&state=hello

授权码获得Token：

/oauth/token?grant_type=authorization_code&code=上面获得的&client_id=test&redirect_uri=http://&scope=all

头增加：Authentication（将test:test1234通过Base64加密）

一个授权码只能换一次令牌

```
{
    "access_token": "950018df-0199-4936-aa80-a3a66183f634",
    "token_type": "bearer",
    "refresh_token": "cc22e8b2-e069-459d-8c24-cfda0bc72128",
    "expires_in": 42827,
    "scope": "all"
}
```

密码模式获取Token：

/oauth/token?grant_type=password&client_id=test&redirect_uri=http://&scope=all

Authentication:





访问接口：http://localhost:8080/index



