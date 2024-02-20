package com.example.OAthTest.service;

import com.example.OAthTest.domain.Member;
import com.example.OAthTest.dto.MemberDetails;
import com.example.OAthTest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Slf4j
public class MemberDetailService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberDetailService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public MemberDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member=Optional.of(memberRepository.findByEmail(username).get()).orElseThrow(()->new UsernameNotFoundException("회원가입이 되있지 않았습니다"));
        log.info(member.getPassword());
        log.info("MemberDetailService 메서드");

        return MemberDetails.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .build();
    }
}
