package com.example.OAthTest.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "kakaoApi",url = "https://kapi.kakao.com")
public interface KakaoApi {
    //"https://kapi.kakao.com/v2/user/me"
    //https://kapi.kakao.com/v1/user/logout
    @GetMapping("/v2/user/me")
    public String getUSerInfo(@RequestHeader("Authorization") String token);
    //@PostMapping("v1/user/logout")
    //public String logout(@RequestHeader("Content-type") String Content, @RequestHeader("Authorization") String token);
}
