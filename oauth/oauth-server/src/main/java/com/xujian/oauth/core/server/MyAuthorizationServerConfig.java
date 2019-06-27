package com.xujian.oauth.core.server;

import com.xujian.oauth.core.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

/**
 * 认证服务器配置
 */
@Configuration
@EnableAuthorizationServer
public class MyAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    /**
     * 注入权限验证控制器 来支持 password grant type
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    /**
     * 注入userDetailsService，开启refresh_token需要用到
     */
    @Autowired
    private MyUserDetailsService userDetailsService;

    /**
     * 数据源
     */
    @Autowired
    private DataSource dataSource;

    /**
     * 设置保存token的方式，一共有五种
     */
    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private WebResponseExceptionTranslator webResponseExceptionTranslator;

    @Bean
    public TokenStore tokenStore() {
        //通过redis存储token
        return new RedisTokenStore(redisConnectionFactory);
        //return new JdbcTokenStore( dataSource );
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        /**
         * 配置oauth2服务跨域
         */
        CorsConfigurationSource source = new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration corsConfiguration = new CorsConfiguration();
                corsConfiguration.addAllowedHeader("*");
                corsConfiguration.addAllowedOrigin(request.getHeader( HttpHeaders.ORIGIN));
                corsConfiguration.addAllowedMethod("*");
                corsConfiguration.setAllowCredentials(true);
                corsConfiguration.setMaxAge(3600L);
                return corsConfiguration;
            }
        };

        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients()
                .addTokenEndpointAuthenticationFilter(new CorsFilter(source));
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource); //通过数据库读取客户端认证配置

        /*clients.inMemory()//配置内存中，也可以是数据库
                .withClient("dev")//clientid
                .secret("dev")
                .accessTokenValiditySeconds(3600)//token有效时间  秒
                .authorizedGrantTypes("refresh_token", "password", "authorization_code")//token模式
                .scopes("all")//限制允许的权限配置

                .and()//下面配置第二个应用   （不知道动态的是怎么配置的，那就不能使用内存模式，应该使用数据库模式来吧）
                .withClient("test")
                .scopes("testSc")
                .accessTokenValiditySeconds(7200)
                .scopes("all");*/
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //开启密码授权类型
        endpoints.authenticationManager(authenticationManager);
        //配置token存储方式
        endpoints.tokenStore(tokenStore);
        //自定义登录或者鉴权失败时的返回信息
        endpoints.exceptionTranslator(webResponseExceptionTranslator);
        //要使用refresh_token的话，需要额外配置userDetailsService
        endpoints.userDetailsService( userDetailsService );
    }
}
