package com.example.OAthTest.jwt;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KakaoToken {
    // // "token_type":"bearer",
    //    //    "access_token":"${ACCESS_TOKEN}",
    //    //    "expires_in":43199,
    //    //    "refresh_token":"${REFRESH_TOKEN}",
    //    //    "refresh_token_expires_in":5184000,
    //    //    "scope":"account_email profile"
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("expires_in")
    private String expires;
    @JsonProperty("refresh_token_expires_in")
    private String refreshExpires;

    private String scope;


}
