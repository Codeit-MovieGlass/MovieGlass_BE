package com.movieglass.backend.domain.home.controller;

import com.movieglass.backend.domain.home.dto.HomeResponseDto;
import com.movieglass.backend.domain.home.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/home")
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping
    public HomeResponseDto getHomeData(@RequestHeader("Authorization") String token) {
        // 토큰에서 userId 추출 (실제 구현에서는 JWT 파싱 필요)
        String userId = extractUserIdFromToken(token);
        return homeService.getHomeData(userId);
    }

    // TODO: JWT에서 userId 추출하는 로직 추가 (예시 메서드)
    private String extractUserIdFromToken(String token) {
        return "user123"; // 테스트용 (임시 하드코딩)
    }
}
