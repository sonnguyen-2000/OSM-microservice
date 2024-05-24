package com.codegym.cglmsauthservice.application.service;

import com.codegym.cglmsauthservice.presentation.dto.CommonResponse;
import com.codegym.cglmsauthservice.presentation.dto.payload.request.LoginRequest;
import com.codegym.cglmsauthservice.presentation.dto.payload.request.RegisterRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cg-lms-user-service")
public interface UserServiceClient {
    @PostMapping("/api/users/register")
    CommonResponse createUser(@RequestBody RegisterRequest registerRequest);
    @PostMapping("/api/users/login")
    CommonResponse checkUser(@RequestBody LoginRequest loginRequest);
}
