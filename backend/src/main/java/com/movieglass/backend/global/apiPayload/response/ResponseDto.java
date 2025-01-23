package com.movieglass.backend.global.apiPayload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDto<T> {
    private final String status;
    private final String message;
    private final T data;
}
