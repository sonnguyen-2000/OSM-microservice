package com.codegym.cglmsauthservice.application.service;

import com.codegym.cglmsauthservice.presentation.dto.CommonResponse;
import com.codegym.cglmsauthservice.presentation.dto.payload.request.LoginRequest;
import com.codegym.cglmsauthservice.presentation.dto.payload.request.RegisterRequest;

public interface AuthService {
    CommonResponse register(RegisterRequest registerRequest);
    CommonResponse login(LoginRequest loginRequest);
}
