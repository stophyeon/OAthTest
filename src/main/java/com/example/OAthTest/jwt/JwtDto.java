package com.example.OAthTest.jwt;

import lombok.Builder;
import lombok.Data;

@Data
public class JwtDto {

    private String accessToken;
    private String refreshToken;
    private String grantType;
    private Long accessTokenExpiresIn;
    @Builder
    public JwtDto(String grantType, String accessToken, String refreshToken,Long accessTokenExpiresIn) {
        this.grantType = grantType;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.accessTokenExpiresIn =accessTokenExpiresIn;
    }
}
