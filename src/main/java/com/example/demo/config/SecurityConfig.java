package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig {

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("admin").password("$2a$12$tTQP7eAAvSbSa7bMZVDWqOjR0NaqhvvBte6fB05MVc/CgscFrkFvG").roles("ADMIN");
    auth.inMemoryAuthentication().withUser("user").password("$2a$12$tTQP7eAAvSbSa7bMZVDWqOjR0NaqhvvBte6fB05MVc/CgscFrkFvG").roles("USER");
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
