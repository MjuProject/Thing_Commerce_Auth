package com.thing.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SignupRequestDTO {

    private String clientId;
    private String clientName;
    private String password;
    private String nickname;
    private String email;
    private Date birthdate;
    private String phoneNumber;

    public void encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(this.password);
    }

}
