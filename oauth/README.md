

本例实现：

- 采用授权码模式（最安全、最完整）
- 请求code和获取token进行了合并
  - 即客户端代理和服务端合并
- 自动approve授权
- header
  - 传递token
  - 传递要操作的权限信息
- Redis存储登录状态
  - 存储、验证、过期
  - 是否过期的判断？
  - 存储key-value，key为用户id，value为token，下次用户登陆成功的时候，根据用户id查询老的token，将其删除掉，然后再生成新的token
- 数据库仅首次验证时，校验用户信息
- token过期
  - 服务端记录access token、refresh token
  - 每次调用业务Api时，先进行时间检查
- 
- 
- 手机号登录
- 邮箱登录
- 附带验证码登录
- 第三方登录
- 
- 资源验证服务分开部署？

#### 参考
DB方式管理：
https://juejin.im/post/5c997ce5e51d4507853e6a9f#heading-13 
https://github.com/gf-huanchupk/SpringBootLearning/tree/master/springboot-security-oauth2

https://segmentfault.com/a/1190000016583573#articleHeader4
https://github.com/zhangwei900808/awbeci-ssb
	

