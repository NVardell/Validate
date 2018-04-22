//package com.chase.digital.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // Unauthenticated Access
//        http.authorizeRequests().antMatchers("/", "/login").permitAll();
//
//        // Authenticated Access
//        http.authorizeRequests().antMatchers("/home", "/results", "/history").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
//    }
//}
