package com.example.OAthTest.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "kakaoApi",url = "https://kapi.kakao.com")
public interface KakaoApi {
    //"https://kapi.kakao.com/v2/user/me"
    @GetMapping("/v2/user/me")
    public String getUSerInfo(@RequestHeader("Authorization") String token);
}
