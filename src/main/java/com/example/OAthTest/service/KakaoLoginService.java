package com.example.OAthTest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KakaoLoginService {
    private final KakaoFeignClient kakaoFeignClient;
    private final String Content_type ="application/x-www-form-urlencoded;charset=utf-8";
    private final String grant_type = "authorization_code";
    private final String client_id = "b9759cba8e0cdd5bcdb9d601f5a10ac1";
    private final String redirect ="http://localhost:8080/oauth2/kakao";

    public KakaoLoginService(KakaoFeignClient kakaoFeignClient) {
        this.kakaoFeignClient = kakaoFeignClient;
    }

    public String getToken(String code){

        return kakaoFeignClient.getAccessToken(Content_type,grant_type,client_id,redirect,code);
    }


}
