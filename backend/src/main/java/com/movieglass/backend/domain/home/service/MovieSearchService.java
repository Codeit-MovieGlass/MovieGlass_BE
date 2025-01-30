package com.movieglass.backend.domain.home.service;

import com.movieglass.backend.domain.home.dto.response.MovieSearchResponseDto;
import com.movieglass.backend.domain.home.dto.MovieSummaryDto;
import com.movieglass.backend.domain.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieSearchService {
    private final MovieRepository movieRepository;

    public MovieSearchResponseDto searchMovies(String query) {
        // 검색 결과 조회
        List<MovieSummaryDto> searchResults = movieRepository
                .findByMovieNameContainingIgnoreCaseOrProductionGenreContainingIgnoreCaseOrProductionKeywordContainingIgnoreCase(
                        query, query, query)
                .stream()
                .map(MovieSummaryDto::from)
                .collect(Collectors.toList());

        // TODO: 추천 영화 로직이 확정되면 변경 (현재는 더미 데이터 반환)
        List<MovieSummaryDto> recommendations = List.of(
                MovieSummaryDto.builder()
                        .movieId("KMDb5678")
                        .title("반지의 제왕")
                        .posterUrl("https://image.url")
                        .build()
        );

        return MovieSearchResponseDto.of(searchResults, recommendations);
    }
}
