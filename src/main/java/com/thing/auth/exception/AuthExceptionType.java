package com.thing.auth.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AuthExceptionType {
    UNKNOWN(-9999, "알 수 없는 오류가 발생하였습니다."),
    PASSWORD_MISMATCH(-2001, "비밀번호가 일치하지 않습니다."),
    TOKEN_NOT_VALID(-2002, "토큰이 유효하지 않습니다.");

    private final int code;
    private final String message;
}
