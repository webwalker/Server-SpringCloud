

本例实现：

- 采用授权码模式
  - 最安全、最完整的方式
- oauth2
- 请求code和获取token进行了合并
  - 即客户端代理和服务端合并
- 自动approve授权
- 数据库查询用户信息
- Redis存储登录状态
  - 存储、验证、过期
- token过期
  - 服务端记录access token、refresh token
  - 每次调用业务Api时，先进行时间检查
- 手机号登录
- 邮箱登录
- 附带验证码登录
- 第三方登录

#### 参考
DB方式管理：
https://juejin.im/post/5c997ce5e51d4507853e6a9f#heading-13 
https://github.com/gf-huanchupk/SpringBootLearning/tree/master/springboot-security-oauth2

https://segmentfault.com/a/1190000016583573#articleHeader4
https://github.com/zhangwei900808/awbeci-ssb
	

