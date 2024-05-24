package com.codegym.cglmscustomerservice.infrastructure.until;

import com.codegym.cglmscustomerservice.presentation.dto.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class BuildResponse {
    public CommonResponse buildResponse(Object data, String message, HttpStatus status) {
        return new CommonResponse(data,message,status);
    }
}
