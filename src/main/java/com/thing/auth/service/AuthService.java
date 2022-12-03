package com.thing.auth.service;

import com.thing.auth.dto.LoginRequestDTO;
import com.thing.auth.dto.SignupRequestDTO;

import java.util.Map;

public interface AuthService {
    public String login(LoginRequestDTO loginRequestDTO);
    public void signup(SignupRequestDTO signupRequestDTO);
    public Map<String, String> valid(String token);
}
