package com.bibhu.springboot.todorestapi01.todo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthenticationSecurityConfiguration {

    //Filter chain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        //authenticate all request
        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        //Basic authentication with username and password present in properties file
        httpSecurity.httpBasic(Customizer.withDefaults());
        //stateless rest api
        httpSecurity.sessionManagement(
            session -> session.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS));
        //disabling csrf
        httpSecurity.csrf(csrf -> csrf.disable());
        return httpSecurity.build();
    }
}
