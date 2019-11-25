package com.wx.springboot.config;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("user1").password(new BCryptPasswordEncoder().encode("123")).roles("vip1","vip2").and()
                .withUser("user2").password(new BCryptPasswordEncoder().encode("123")).roles("vip2","vip3").and()
                .withUser( "user3").password(new BCryptPasswordEncoder().encode("123")).roles("vip1","vip3");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests().mvcMatchers("/").permitAll()
                .mvcMatchers("/level1/**").hasRole("vip1")
                .mvcMatchers("/level2/**").hasRole("vip2")
                .mvcMatchers("/level3/**").hasRole("vip3")
                .mvcMatchers("/userlogin").permitAll() ;
        http.formLogin();
        http.logout().logoutSuccessUrl("/");
    }


}
