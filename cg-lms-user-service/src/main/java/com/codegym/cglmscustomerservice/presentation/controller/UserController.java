package com.codegym.cglmscustomerservice.presentation.controller;

import com.codegym.cglmscustomerservice.application.service.UserService;
import com.codegym.cglmscustomerservice.presentation.dto.CommonResponse;
import com.codegym.cglmscustomerservice.presentation.dto.payload.request.LoginRequest;
import com.codegym.cglmscustomerservice.presentation.dto.payload.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<CommonResponse> createUser(@RequestBody RegisterRequest request) {
        CommonResponse commonResponse = userService.createUser(request);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }
    @PostMapping("/login")
    public ResponseEntity<CommonResponse> login(@RequestBody LoginRequest request) {
        CommonResponse commonResponse = userService.checkUserLogin(request);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }
}
