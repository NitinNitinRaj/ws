package com.nr.ws.security;

import com.nr.ws.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

  @Autowired
  private UserService userService;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(
      AuthenticationManagerBuilder.class
    );

    authenticationManagerBuilder
      .userDetailsService(userService)
      .passwordEncoder(bCryptPasswordEncoder);

    // AuthenticationManager authenticationManager = authenticationManagerBuilder.build();
    // http.authenticationManager(authenticationManager);
    http
      .headers()
      .frameOptions()
      .disable()
      .and()
      .csrf()
      .disable()
      .authorizeRequests()
      .antMatchers("/h2/**")
      .permitAll()
      .antMatchers(HttpMethod.POST, SecurityConstant.SIGN_UP_URL)
      .permitAll()
      .anyRequest()
      .authenticated()
      .and()
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    return http.build();
  }
}
