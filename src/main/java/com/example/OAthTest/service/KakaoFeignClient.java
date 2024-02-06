package com.example.OAthTest.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "kakao",url = "https://kauth.kakao.com/oauth")
public interface KakaoFeignClient {
    @PostMapping("/token")
    public String getAccessToken(@RequestHeader("Content-type") String Content,
                                 @RequestParam("grant_type") String grant,
                                 @RequestParam("client_id") String client,
                                 @RequestParam("redirect_uri") String redirect,
                                 @RequestParam("code") String code);
}
