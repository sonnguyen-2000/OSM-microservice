package com.codegym.cglmsauthservice.infrastructure;

import com.codegym.cglmsauthservice.presentation.dto.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class BuildResponse {
    public CommonResponse buildCommonResponse(Object data, String message, HttpStatus status) {
        return new CommonResponse(data, message, status);
    }
}
