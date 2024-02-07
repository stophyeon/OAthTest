package com.example.OAthTest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class KakaoServiceTest {
    @Autowired
    KakaoApi kakaoApi;
    @Autowired
    KakaoFeignClient kakaoFeignClient;
    private final String Content_type ="application/x-www-form-urlencoded;charset=utf-8";

    private final String grant_type = "authorization_code";
    private final String client_id = "b9759cba8e0cdd5bcdb9d601f5a10ac1";
    private final String login_redirect ="http://localhost:8080/oauth2/kakao";
    private final String logout_redirect ="http://localhost:8080";

    @Test
    void getToken() {
        String code ="s2E5oLj1CmLt2bbsgnjEmTTtntTmB529Rt0mAtjECC4t9B--DYXBSENEkuIKKclfAAABjYG8uKFUdd9ffL_GXA";
        System.out.println(kakaoFeignClient.getAccessToken(Content_type,grant_type,client_id,login_redirect,code));
    }

    @Test
    void getInfo() {
    }
}