package com.example.OAthTest.service;

import com.example.OAthTest.domain.Member;
import com.example.OAthTest.jwt.JwtDto;
import com.example.OAthTest.jwt.KakaoToken;
import com.example.OAthTest.repository.MemberRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KakaoService {

    //  -H "Content-Type: application/x-www-form-urlencoded" \
    //  -H "Authorization: Bearer ${ACCESS_TOKEN}"
    private final KakaoFeignClient kakaoFeignClient;
    private final KakaoApi kakaoApi;
    private final MemberRepository memberRepository;

    private final String Content_type ="application/x-www-form-urlencoded;charset=utf-8";

    private final String grant_type = "authorization_code";
    private final String client_id = "b9759cba8e0cdd5bcdb9d601f5a10ac1";
    private final String login_redirect ="http://localhost:8080/oauth2/kakao";
    private final String logout_redirect ="http://localhost:8080";
    private KakaoToken kakaoToken;
    public KakaoService(KakaoFeignClient kakaoFeignClient, KakaoApi kakaoApi, MemberRepository memberRepository) {
        this.kakaoFeignClient = kakaoFeignClient;
        this.kakaoApi = kakaoApi;

        this.memberRepository = memberRepository;
    }

    public String getToken(String code) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        kakaoToken=objectMapper.readValue(kakaoFeignClient.getAccessToken(Content_type,grant_type,client_id,login_redirect,code), KakaoToken.class);
        return kakaoToken.toString();
    }
    public void logOutMember(){

        kakaoFeignClient.logOut(client_id, logout_redirect);
    }
    public Member getInfo() throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(kakaoApi.getUSerInfo("Bearer "+kakaoToken.getAccessToken()));
        JSONObject properties = (JSONObject) jsonObject.get("properties");
        JSONObject account = (JSONObject) jsonObject.get("kakao_account");
        Member member=Member.builder()
                .name(properties.get("nickname").toString())
                .email(account.get("email").toString())
                .build();
        memberRepository.save(member);
        return member;
    }
}
