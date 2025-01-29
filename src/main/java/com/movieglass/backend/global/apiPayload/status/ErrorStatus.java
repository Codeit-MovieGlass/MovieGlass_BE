package com.movieglass.backend.global.apiPayload.status;

import com.movieglass.backend.global.apiPayload.base.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    BAD_REQUEST("400", "잘못된 요청입니다."),
    UNAUTHORIZED("401", "인증이 필요합니다."),
    FORBIDDEN("403", "권한이 없습니다."),
    NOT_FOUND("404", "요청한 리소스를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR("500", "서버 내부 오류가 발생했습니다.");

    private final String code;
    private final String message;
}
