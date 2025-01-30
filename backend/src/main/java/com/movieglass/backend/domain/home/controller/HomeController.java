package com.movieglass.backend.domain.home.controller;

import com.movieglass.backend.domain.home.dto.HomeResponseDto;
import com.movieglass.backend.domain.home.dto.response.MovieSearchResponseDto;
import com.movieglass.backend.domain.home.service.HomeService;
import com.movieglass.backend.domain.home.service.MovieSearchService;
import com.movieglass.backend.global.apiPayload.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/home")
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;
    private final MovieSearchService movieSearchService;

    @GetMapping
    public ApiResponse<HomeResponseDto> getHomeData(@RequestHeader("Authorization") String token) {
        String userId = extractUserIdFromToken(token);
        HomeResponseDto homeData = homeService.getHomeData(userId);
        return ApiResponse.success("홈 데이터를 성공적으로 가져왔습니다.", homeData);
    }

    // TODO: JWT에서 userId 추출하는 로직 추가 (예시 메서드)
    private String extractUserIdFromToken(String token) {
        return "user123"; // 테스트용 (임시 하드코딩)
    }


    @GetMapping("/movies/search")
    public ApiResponse<MovieSearchResponseDto> searchMovies(@RequestParam("query") String query) {
        MovieSearchResponseDto searchResults = movieSearchService.searchMovies(query);
        return ApiResponse.success("영화 검색 결과를 성공적으로 가져왔습니다.", searchResults);
    }
}