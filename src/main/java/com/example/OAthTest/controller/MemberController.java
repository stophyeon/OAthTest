package com.example.OAthTest.controller;

import com.example.OAthTest.dto.MemberDto;
import com.example.OAthTest.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/join")
    public String signup(@RequestBody @Valid MemberDto memberDto){
        return memberService.signupMember(memberDto);
    }

}
