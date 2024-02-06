package com.example.OAthTest.controller;

import com.example.OAthTest.dto.MemberDto;
import com.example.OAthTest.jwt.JwtDto;
import com.example.OAthTest.service.JwtLoginService;
import com.example.OAthTest.service.MemberService;
import io.jsonwebtoken.Jwt;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    private final JwtLoginService jwtLoginService;
    public MemberController(MemberService memberService, JwtLoginService jwtLoginService) {
        this.memberService = memberService;
        this.jwtLoginService = jwtLoginService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@RequestBody MemberDto memberDto){
        JwtDto jwt = jwtLoginService.loginMember(memberDto);
        return ResponseEntity.status(HttpStatus.OK).body(jwt);
    }
    @PostMapping("/join")
    public String signup(@RequestBody @Valid MemberDto memberDto){
        return memberService.signupMember(memberDto);
    }


}
