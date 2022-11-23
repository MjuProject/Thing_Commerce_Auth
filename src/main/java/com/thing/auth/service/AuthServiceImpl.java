package com.thing.auth.service;

import com.thing.auth.client.ClientsServiceClient;
import com.thing.auth.config.JwtTokenProvider;
import com.thing.auth.dto.LoginInfoDTO;
import com.thing.auth.dto.LoginRequestDTO;
import com.thing.auth.dto.SignupRequestDTO;
import com.thing.auth.exception.PasswordMisMatchException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final ClientsServiceClient clientsServiceClient;

    @Override
    public String login(LoginRequestDTO loginRequestDTO) {
        LoginInfoDTO loginInfoDTO = clientsServiceClient.showClientById(loginRequestDTO.getClientId()).getData();
        if (!passwordEncoder.matches(loginRequestDTO.getPassword(), loginInfoDTO.getPassword())){
            throw new PasswordMisMatchException();
        }
        return jwtTokenProvider.createToken(loginInfoDTO.getClientIndex(), loginInfoDTO.getRole());
    }

    @Override
    public void signup(SignupRequestDTO signupRequestDTO) {
        signupRequestDTO.encodePassword(passwordEncoder);
        clientsServiceClient.registryClient(signupRequestDTO);
    }
}
