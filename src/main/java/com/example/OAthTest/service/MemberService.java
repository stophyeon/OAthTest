package com.example.OAthTest.service;

import com.example.OAthTest.domain.Member;
import com.example.OAthTest.dto.MemberDto;
import com.example.OAthTest.jwt.JwtDto;
import com.example.OAthTest.jwt.JwtProvider;
import com.example.OAthTest.repository.MemberRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;



    public MemberService(PasswordEncoder passwordEncoder, MemberRepository memberRepository) {
        this.passwordEncoder = passwordEncoder;
        this.memberRepository = memberRepository;

    }

    public String signupMember(MemberDto memberDto){

        if (memberRepository.findByEmail(memberDto.getEmail()).isPresent()){
           return "이미 가입되어 있습니다.";
        }
        else{

            memberRepository.save(Member.builder()
                    .email(memberDto.getEmail())
                    .password(passwordEncoder.encode(memberDto.getPassword()))
                    .name(memberDto.getName())
                    .build()
            );
            return "가입에 성공했습니다";
        }
    }

}
