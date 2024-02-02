package com.example.OAthTest.service;

import com.example.OAthTest.domain.Member;
import com.example.OAthTest.dto.MemberDto;
import com.example.OAthTest.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    public MemberService(PasswordEncoder passwordEncoder, MemberRepository memberRepository) {
        this.passwordEncoder = passwordEncoder;
        this.memberRepository = memberRepository;
    }
    public String signupMember(MemberDto memberDto){
        Optional<Member> member = memberRepository.findByEmail(memberDto.getEmail());
        if (member.isPresent()){
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
