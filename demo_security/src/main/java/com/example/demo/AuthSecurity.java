package com.example.demo;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AuthSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable().csrf().disable();

        http.authorizeRequests().antMatchers("/index").permitAll().anyRequest().authenticated();
        http.httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        auth.inMemoryAuthentication().withUser("user1").password(encoder.encode("123")).roles("Guest").and().
//                withUser("user2").password(encoder.encode("123")).roles("Guest", "User", "Admin").and().
//                withUser("user3").password(encoder.encode("123")).roles("Guest", "User");
        auth.inMemoryAuthentication().withUser("user1").password("{noop}123").roles("Guest").and().
                withUser("user2").password("{noop}1234").roles("Guest", "User", "Admin").and().
                withUser("user3").password("{noop}1235").roles("Guest", "User");

    }
}
