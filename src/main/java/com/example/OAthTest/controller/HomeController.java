package com.example.OAthTest.controller;


import com.example.OAthTest.service.KakaoLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final KakaoLoginService kakaoLoginService;

    public HomeController(KakaoLoginService kakaoLoginService) {
        this.kakaoLoginService = kakaoLoginService;
    }

    @GetMapping("/oauth2/kakao")
    public String index(@RequestParam("code") String code){
        return kakaoLoginService.getToken(code);
    }
}
