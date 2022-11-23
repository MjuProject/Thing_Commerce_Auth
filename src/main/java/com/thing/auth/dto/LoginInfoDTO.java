package com.thing.auth.dto;

import com.thing.auth.type.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class LoginInfoDTO {
    private Integer clientIndex;
    private String clientId;
    private String password;
    private Role role;
}
