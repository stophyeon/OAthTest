package com.example.OAthTest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@RequiredArgsConstructor
public class MemberDto {
    private String name;
    @NotBlank(message = "이메일은 필수 입력정보입니다.")
    @Email
    private String email;
    @NotBlank(message = "필수 입력정보입니다.")
    @Size(min=4,max=8)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).+$", message = "영문,숫자,특수기호가 포함되어야 합니다.")
    private String password;

}
