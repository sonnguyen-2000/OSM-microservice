package com.codegym.cglmscustomerservice.application.service.impl;

import com.codegym.cglmscustomerservice.application.converter.UserConverter;
import com.codegym.cglmscustomerservice.application.service.UserService;
import com.codegym.cglmscustomerservice.domain.constant.MessageConstant;
import com.codegym.cglmscustomerservice.domain.entity.User;
import com.codegym.cglmscustomerservice.infrastructure.repository.UserRepository;
import com.codegym.cglmscustomerservice.infrastructure.until.BuildResponse;
import com.codegym.cglmscustomerservice.presentation.dto.CommonResponse;
import com.codegym.cglmscustomerservice.presentation.dto.payload.request.LoginRequest;
import com.codegym.cglmscustomerservice.presentation.dto.payload.request.RegisterRequest;
import com.codegym.cglmscustomerservice.presentation.dto.payload.response.LoginResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final BuildResponse commonResponse;

    @Override
    @Transactional
    public CommonResponse createUser(RegisterRequest request) {
        if (!isUserExist(request.getUsername())) {
            User user = userConverter.convertToUser(request);
            userRepository.save(user);
            return commonResponse.buildResponse(null, MessageConstant.REGISTER_SUCCESS, HttpStatus.CREATED);
        }
        return commonResponse.buildResponse(null, MessageConstant.REGISTER_FAIL, HttpStatus.BAD_REQUEST);
    }

    @Override
    public CommonResponse checkUserLogin(LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findByUsername(loginRequest.getUsername());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
           if(isUserAvailable(user,loginRequest)){
               return commonResponse.buildResponse(new LoginResponse(true),MessageConstant.LOGIN_SUCCESS,HttpStatus.OK);
           }
        }
        return commonResponse.buildResponse(new LoginResponse(false),MessageConstant.LOGIN_FAIL,HttpStatus.BAD_REQUEST);
    }

    private boolean isUserExist(String username) {
        return userRepository.existsByUsername(username);
    }
    private boolean isUserAvailable(User user, LoginRequest loginRequest) {
        return user.getUsername().equals(loginRequest.getUsername()) && user.getPassword().equals(loginRequest.getPassword());
    }
}
