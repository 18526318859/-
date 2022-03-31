package com.example.meeting2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override//请求
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println ("这里执行了请求授权" );
        http.authorizeRequests ().antMatchers ( "/index","/login","/tomenu" ).permitAll ();
        http.authorizeRequests ().antMatchers ( "/emp" ,"/emp/show").hasRole ( "vip1" );
        /*http.authorizeRequests().antMatchers ( "/index" ).permitAll ();
        http.authorizeRequests ().antMatchers ( "/main" ).hasAuthority ( "vip1" );
        http.authorizeRequests ().antMatchers ( "/list" ).hasAuthority ( "vip2" );*/
        http.formLogin ().loginPage ( "/index" ).loginProcessingUrl ( "/login" ).successForwardUrl ( "/tomenu" );
        http.rememberMe ();
        http.logout ();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println ("这里请求了安全认证" );

        auth.inMemoryAuthentication().passwordEncoder ( new BCryptPasswordEncoder (  ) )
                .withUser("wang").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2");

    }

    @Bean
    public PasswordEncoder password(){
        //密码加密
        return  new BCryptPasswordEncoder ( );
    }


}
