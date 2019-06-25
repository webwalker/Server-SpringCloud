- 主要类

```
AuthorizationServerConfiguration
ResourceServerConfig

```

- ### 密码授权模式

[ 密码模式需要参数：username , password , grant_type , client_id , client_secret ]  

请求token：

```
curl -X POST -d "username=admin&password=123456&grant_type=password&client_id=dev&client_secret=dev" http://localhost:8080/oauth/token

返回：
{
	"access_token": "d94ec0aa-47ee-4578-b4a0-8cf47f0e8639",
	"token_type": "bearer",
	"refresh_token": "23503bc7-4494-4795-a047-98db75053374",
	"expires_in": 3475,
	"scope": "app"
}
```

不携带token访问资源:

```
curl http://localhost:8080/hi\?name\=zhangsan
返回：
{
	"error": "unauthorized",
	"error_description": "Full authentication is required to access this resource"
}
```

携带token访问资源:

```
curl http://localhost:8080/hi\?name\=zhangsan\&access_token\=164471f7-6fc6-4890-b5d2-eb43bda3328a

返回：hi , zhangsan
```

刷新token：

```
curl  -X POST -d 'grant_type=refresh_token&refresh_token=23503bc7-4494-4795-a047-98db75053374&client_id=dev&client_secret=dev' http://localhost:8080/oauth/token
返回：
{
    "access_token": "ef53eb01-eb9b-46d8-bd58-7a0f9f44e30b",
    "token_type": "bearer",
    "refresh_token": "23503bc7-4494-4795-a047-98db75053374",
    "expires_in": 3599,
    "scope": "app"
}
```

- ### 客户端授权模式

[ 客户端模式需要参数：grant_type , client_id , client_secret ]  

请求token：

```
curl -X POST -d "grant_type=client_credentials&client_id=dev&client_secret=dev" http://localhost:8080/oauth/token

返回：
{
	"access_token": "a7be47b3-9dc8-473e-967a-c7267682dc66",
	"token_type": "bearer",
	"expires_in": 3564,
	"scope": "app"
}
```

- ### 授权码模式

  获取code:

  ```
  http://localhost:8080/oauth/authorize?response_type=code&client_id=dev&redirect_uri=http://www.baidu.com
  
  跳转到登录页面，输入账号和密码进行认证。
  认证后会跳转到授权确认页面（oauth_client_details 表中 “autoapprove” 字段设置为true 时，不会出授权确认页面）：
  确认后，会跳转到百度，并且地址栏中会带上我们想得到的code参数：
  ```

  通过code换token：

  ```
  curl -X POST -d "grant_type=authorization_code&code=qS03iu&client_id=dev&client_secret=dev&redirect_uri=http://www.baidu.com" http://localhost:8080/oauth/token
  
  返回：
  {
      "access_token": "90a246fa-a9ee-4117-8401-ca9c869c5be9",
      "token_type": "bearer",
      "refresh_token": "23503bc7-4494-4795-a047-98db75053374",
      "expires_in": 3319,
      "scope": "app"
  }
  ```

  