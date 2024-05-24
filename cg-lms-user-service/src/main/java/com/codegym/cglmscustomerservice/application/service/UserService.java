package com.codegym.cglmscustomerservice.application.service;

import com.codegym.cglmscustomerservice.presentation.dto.CommonResponse;
import com.codegym.cglmscustomerservice.presentation.dto.payload.request.LoginRequest;
import com.codegym.cglmscustomerservice.presentation.dto.payload.request.RegisterRequest;

public interface UserService {
    CommonResponse createUser(RegisterRequest request);
    CommonResponse checkUserLogin(LoginRequest loginRequest);
}
