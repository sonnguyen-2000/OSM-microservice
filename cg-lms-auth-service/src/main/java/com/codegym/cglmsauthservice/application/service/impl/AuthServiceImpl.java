package com.codegym.cglmsauthservice.application.service.impl;

import com.codegym.cglmsauthservice.application.service.AuthService;
import com.codegym.cglmsauthservice.application.service.UserServiceClient;
import com.codegym.cglmsauthservice.domain.AuthConstant;
import com.codegym.cglmsauthservice.presentation.dto.CommonResponse;
import com.codegym.cglmsauthservice.presentation.dto.payload.request.LoginRequest;
import com.codegym.cglmsauthservice.presentation.dto.payload.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserServiceClient userServiceClient;

    @Override
    public CommonResponse register(RegisterRequest registerRequest) {
        return userServiceClient.createUser(registerRequest);
    }
    @Override
    public CommonResponse login(LoginRequest loginRequest) {
        if (loginRequest.getUsername() != null && loginRequest.getPassword() != null) {
            CommonResponse commonResponse = userServiceClient.checkUser(loginRequest);
            if (commonResponse.getStatus().equals(HttpStatus.OK)) {
                return commonResponse;
            }
        }
        return CommonResponse.builder()
                .data(null)
                .message(AuthConstant.LOGIN_FAILED)
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }
}
