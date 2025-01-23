package com.movieglass.backend.global.apiPayload.status;

import com.movieglass.backend.global.apiPayload.base.BaseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    SUCCESS("200", "요청이 성공적으로 처리되었습니다."),
    CREATED("201", "새로운 리소스가 생성되었습니다.");

    private final String code;
    private final String message;
}
