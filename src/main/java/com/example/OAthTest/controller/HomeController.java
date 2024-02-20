package com.example.OAthTest.controller;


import com.example.OAthTest.service.KakaoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final KakaoService kakaoLoginService;

    public HomeController(KakaoService kakaoLoginService) {
        this.kakaoLoginService = kakaoLoginService;
    }

    @GetMapping("/oauth2/kakao")
    public String index(@RequestParam("code") String code) throws JsonProcessingException {
        return kakaoLoginService.getToken(code);
    }
    @GetMapping("/oauth2/insta")
    public String instagram(@RequestParam("code") String code) throws JsonProcessingException {
        return kakaoLoginService.getToken(code);
    }

    @GetMapping("/info")
    public String MemberInfo() throws ParseException {

        return kakaoLoginService.getInfo().getName();
    }
}
