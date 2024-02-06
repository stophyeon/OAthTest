package com.example.OAthTest.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class OAuth2Member implements OAuth2User {
    private final OAuth2Response oAuth2Response;
    private final String role;

    public OAuth2Member(OAuth2Response oAuth2Response, String role) {
        this.oAuth2Response = oAuth2Response;

        this.role = role;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return role;
            }
        });
        return authorities;
    }

    @Override
    public String getName() {
        return oAuth2Response.getName();
    }
}
