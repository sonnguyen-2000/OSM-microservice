package com.codegym.cglmscustomerservice.application.converter;

import com.codegym.cglmscustomerservice.domain.entity.User;
import com.codegym.cglmscustomerservice.presentation.dto.payload.request.RegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public User convertToUser(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setAddress(request.getAddress());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setFullName(request.getFullName());
        return user;
    }
}
