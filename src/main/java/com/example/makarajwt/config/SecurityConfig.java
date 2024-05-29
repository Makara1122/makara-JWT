package com.example.makarajwt.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.AbstractConfiguredSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws  Exception {
//        return httpSecurity
//                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/v1/auth/login","/api/v1/auth/register","api/v1/auth/refresh-token").
//                        permitAll().
//                        requestMatchers(("/api/v1/contents/read").hasRole("USER").
//                        anyRequest().
//                        authenticated()).
//                httpBasic(AbstractHttpConfigurer::disable).
//                csrf(AbstractHttpConfigurer::disable).
//                formLogin(AbstractHttpConfigurer::disable).
//                sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).
//                exceptionHandling(exception -> exception.authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint()).accessDeniedHandler(new BearerTokenAccessDeniedHandler())).
//                oauth2ResourceServer(oauth2 -> oauth2.jwt(jwtConfigurer ->jwtConfigurer.jwtAuthenticationConverter(JwtToUserConverter()))).build();
//
//    }
}
