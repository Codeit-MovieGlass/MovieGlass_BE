package com.movieglass.backend.domain.home.dto;

import com.movieglass.backend.domain.movie.entity.Movie;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MovieSummaryDto {
    private final String movieId;
    private final String title;
    private final String posterUrl;

    public static MovieSummaryDto from(Movie movie) {
        return MovieSummaryDto.builder()
                .movieId(movie.getId().toString())
                .title(movie.getMovieName())
                .posterUrl(movie.getProductionImage())
                .build();
    }
}
