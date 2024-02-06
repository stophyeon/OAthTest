package com.example.OAthTest.config;

import com.example.OAthTest.jwt.JwtFilter;
import com.example.OAthTest.jwt.JwtProvider;
import com.example.OAthTest.service.JwtLoginService;
import com.example.OAthTest.service.MemberDetailService;
import com.example.OAthTest.service.Oath2LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@EnableWebSecurity
@Component
public class SecurityConfig {
    private final JwtProvider jwtProvider;
    private final MemberDetailService memberDetailService;
    private final Oath2LoginService oath2LoginService;
    public SecurityConfig(JwtProvider jwtProvider, MemberDetailService memberDetailService, Oath2LoginService oath2LoginService) {
        this.jwtProvider = jwtProvider;

        this.memberDetailService = memberDetailService;
        this.oath2LoginService = oath2LoginService;
    }
    @Bean
    protected AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(memberDetailService);
        return provider;

    }

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .oauth2Login(o->o.userInfoEndpoint(userInfoEndpointConfig -> userInfoEndpointConfig.userService(oath2LoginService)))
                .authorizeHttpRequests(req->req.anyRequest().permitAll())
                //.addFilterBefore(new JwtFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
