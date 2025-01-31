package com.movieglass.backend.domain.user.entity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "로그인 성공!"; // 인증에 성공하면 이 메시지가 반환됩니다.
    }
}

