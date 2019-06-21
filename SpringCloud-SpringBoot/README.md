# SpringBoot


静态资源存放位置：
1、从classpath/static目录下查找
2、从ServerContext根目录(webapp)

SpringBoot默认配置文件：application.properties

视图层：
jsp、freemarker(通过HBuilder来开发)、Thymeleaf
SpringBoot 要求模板形式的视图层文件必须放到 src/main/resources 目录下必须要一个名称为 templates(该目录是安全的,不允许外界直接访问)。

持久层：
有时候自动注解扫描不到mybatis的mapper，所以最好：不管自动生成还是手写，都放在resources/mapper下

校验：
由于 springmvc 会将该对象放入到 Model 中传递。key 的名称会使用该对象的驼峰式的命名规则来作为 key。
要求参数对象的变量名必须是对象的类名的全称首字母小写，如User user;

异常处理：
1、自定义的错误页面，需要再 src/main/resources/templates 目录下创建 error.html 页面。
2、全局异常类GlobalException：
    @ControllerAdvice+@ExceptionHandler
    SimpleMappingExceptionResolver
    HandlerExceptionResolver 

热部署：
SpringLoader:SpringLoader 在部署项目时使用的是热部署的方式。 
DevTools: spring-boot-devtools，更简洁，在部署项目时使用的是重新部署的方式。

环境切换


