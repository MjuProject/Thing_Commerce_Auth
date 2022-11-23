package com.thing.auth.controller;

import com.thing.auth.dto.APIResponseDTO;
import com.thing.auth.dto.LoginRequestDTO;
import com.thing.auth.dto.SignupRequestDTO;
import com.thing.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/login")
    public APIResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){
        return APIResponseDTO.success(authService.login(loginRequestDTO));
    }

    @PostMapping(value = "/signup")
    public APIResponseDTO signup(@RequestBody SignupRequestDTO signupRequestDTO){
        authService.signup(signupRequestDTO);
        return APIResponseDTO.success();
    }

}
