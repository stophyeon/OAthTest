package com.example.OAthTest.service;

import com.example.OAthTest.dto.MemberDto;
import com.example.OAthTest.jwt.JwtDto;
import com.example.OAthTest.jwt.JwtProvider;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class JwtLoginService {
    private final JwtProvider jwtProvider;
    private final AuthenticationProvider authenticationProvider;

    public JwtLoginService(JwtProvider jwtProvider, AuthenticationProvider authenticationProvider) {
        this.jwtProvider = jwtProvider;
        this.authenticationProvider = authenticationProvider;

    }
    public JwtDto loginMember(MemberDto memberDto){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(memberDto.getEmail(),memberDto.getPassword());
        Authentication auth = authenticationProvider.authenticate(token);
        return jwtProvider.createToken(auth);
    }
}
