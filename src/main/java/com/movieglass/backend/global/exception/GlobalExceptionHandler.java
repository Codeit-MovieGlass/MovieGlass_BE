package com.movieglass.backend.global.exception;

import com.movieglass.backend.global.apiPayload.response.ErrorResponseDto;
import com.movieglass.backend.global.apiPayload.status.ErrorStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomException(CustomException ex) {
        return ResponseEntity.status(Integer.parseInt(ex.getErrorCode().getCode()))
                .body(new ErrorResponseDto(ex.getErrorCode()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception ex) {
        return ResponseEntity.status(500)
                .body(new ErrorResponseDto(ErrorStatus.INTERNAL_SERVER_ERROR));
    }
}
