package com.movieglass.backend.global.apiPayload.response;

import com.movieglass.backend.global.apiPayload.base.BaseErrorCode;
import lombok.Getter;

@Getter
public class ErrorResponseDto {
    private final String status;
    private final String message;

    public ErrorResponseDto(BaseErrorCode errorCode) {
        this.status = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}
