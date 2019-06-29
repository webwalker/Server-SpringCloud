体验下来之后，发现其实并没有那么好用，如果真有需要，可以自己去实现这套机制，更灵活和可控：

- token生成、验证、过期管理

- 数据库用户、角色、权限

- 注解权限拦截

  


本例实现：

- 密码模式
- 数据库
  - 登录用户信息、角色、权限、映射关系
  - 客户端ID、Secret配置
- Redis
  - 存储Token、验证、过期
  - 是否过期的判断？
  - 存储key-value，key为用户id，value为token，下次用户登陆成功的时候，根据用户id查询老的token，将其删除掉，然后再生成新的token
- token过期
  - 服务端记录access token、refresh token
  - 每次调用业务Api时，先进行时间检查
- header
  - 传递token
  - 传递要操作的权限信息
- 
- 资源验证服务分开部署？
- 待补充
  - 手机登录
- 注意
  - 不要采用jwt的方式，不方便接口调用

#### 参考

DB方式管理：
https://juejin.im/post/5c997ce5e51d4507853e6a9f#heading-13 
https://github.com/gf-huanchupk/SpringBootLearning/tree/master/springboot-security-oauth2

使用Spring Security和OAuth2保护REST接口（Good）：
https://mp.weixin.qq.com/s/l7ZLcSKQykJdpNVq_JpB-g

Redis管理：
https://segmentfault.com/a/1190000016583573#articleHeader4
https://github.com/zhangwei900808/awbeci-ssb



### 密码授权模式 

[ 密码模式需要参数：username , password , grant_type , client_id , client_secret ]

```
curl -X POST -d "username=admin&password=123456&grant_type=password&client_id=dev&client_secret=dev" http://localhost:8080/oauth/token

{
	"access_token": "d94ec0aa-47ee-4578-b4a0-8cf47f0e8639",
	"token_type": "bearer",
	"refresh_token": "23503bc7-4494-4795-a047-98db75053374",
	"expires_in": 3475,
	"scope": "app"
}
```

不携带token访问资源

```
curl http://localhost:8080/hi\?name\=zhangsan
{
	"error": "unauthorized",
	"error_description": "Full authentication is required to access this resource"
}
```

携带token访问资源

```
curl http://localhost:8080/hi\?name\=zhangsan\&access_token\=164471f7-6fc6-4890-b5d2-eb43bda3328a

hi , zhangsan
```

然后通过Redis Desktop Manage 客户端查看存储的key信息。

