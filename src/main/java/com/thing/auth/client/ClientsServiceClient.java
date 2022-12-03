package com.thing.auth.client;

import com.thing.auth.dto.APIResponseDTO;
import com.thing.auth.dto.LoginInfoDTO;
import com.thing.auth.dto.SignupRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "client-service")
public interface ClientsServiceClient {

    @GetMapping(value = "/clients/id/{client-id}", produces = "application/json")
    APIResponseDTO<LoginInfoDTO> showClientById(@PathVariable("client-id") String clientId);

    @PostMapping("/clients")
    void registryClient(SignupRequestDTO signupRequestDTO);
}
