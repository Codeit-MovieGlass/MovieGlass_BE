package com.movieglass.backend.domain.home.dto.response;

import com.movieglass.backend.domain.home.dto.MovieSummaryDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MovieSearchResponseDto {
    private final List<MovieSummaryDto> searchResults;
    private final List<MovieSummaryDto> recommendations;

    public static MovieSearchResponseDto of(List<MovieSummaryDto> searchResults, List<MovieSummaryDto> recommendations) {
        return MovieSearchResponseDto.builder()
                .searchResults(searchResults)
                .recommendations(recommendations)
                .build();
    }
}
