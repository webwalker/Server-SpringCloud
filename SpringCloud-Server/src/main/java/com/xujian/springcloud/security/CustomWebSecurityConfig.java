package com.xujian.springcloud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//自定义安全策略，取代配置文件中的设定
@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();

        //等同于security.basic.enabled=false
        http.authorizeRequests().antMatchers("/**").permitAll();
        //开启Security之后，如果不关闭这里，POST方法都会报403错误，无法调用
        http.csrf().disable();

        //开启过滤性验证
//        http.authorizeRequests()
//                    .antMatchers("/resources/**", "/signup", "/about").permitAll()
//                    .antMatchers("/admin/**").hasRole("ADMIN")
//                    .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
//                    .anyRequest().authenticated()
//                    .and() //对应了一个模块的配置（等同于xml配置中的结束标签）
//                .formLogin()
//                    .usernameParameter("username")
//                    .passwordParameter("password")
//                    .failureForwardUrl("/login?exception")
//                    .loginPage("/login")
//                    .permitAll()
//                    .and()
//                .logout()
//                    .logoutUrl("/logout")
//                    .logoutSuccessUrl("/index")
//                    .permitAll()
//                    .and()
//                .httpBasic()
//                    .disable();

//        http.authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    //配置一个userDetailsService Bean不在生成默认security.user用户
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetailsService uds = new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
                return null;
            }
        };
        return uds;
    }

    //内存中验证
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("USER");
    }
}
