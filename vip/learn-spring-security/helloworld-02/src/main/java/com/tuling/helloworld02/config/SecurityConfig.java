package com.tuling.helloworld02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    /**
     * 配置过滤器链
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //表单提交

        http.formLogin((formLogin) -> formLogin
                .loginPage("/login.html") //指定自定义登录页面地址
                .loginProcessingUrl("/user/login")//登录访问路径：前台界面提交表单之后跳转到这个路径进行UserDetailsService的验证，必须和表单提交接口一样
                .defaultSuccessUrl("/admin/demo")//认证成功之后跳转的路径

        );
        //对请求进行访问控制设置
        http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                //设置哪些路径可以直接访问，不需要认证
                .requestMatchers("/login.html","/user/login").permitAll()
                .anyRequest().authenticated() //其他路径的请求都需要认证
        );
        //关闭跨站点请求伪造csrf防护
        http.csrf((csrf) -> csrf.disable());

        return http.build();
    }


    @Bean
    UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("fox")
                .password("123456")
                .roles("user")
                .build();
        return new InMemoryUserDetailsManager(user);
    }


}
