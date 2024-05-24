package com.codegym.cglmsauthservice.presentation.controller;

import com.codegym.cglmsauthservice.application.service.AuthService;
import com.codegym.cglmsauthservice.application.service.UserServiceClient;
import com.codegym.cglmsauthservice.presentation.dto.CommonResponse;
import com.codegym.cglmsauthservice.presentation.dto.payload.request.LoginRequest;
import com.codegym.cglmsauthservice.presentation.dto.payload.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserServiceClient userServiceClient;
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<CommonResponse> createUser(@RequestBody RegisterRequest registerRequest) {
        CommonResponse commonResponse = authService.register(registerRequest);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }
    @PostMapping("/login")
    public ResponseEntity<CommonResponse> login(@RequestBody LoginRequest loginRequest) {
        CommonResponse commonResponse = authService.login(loginRequest);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }
}
