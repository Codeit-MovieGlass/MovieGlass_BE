package com.movieglass.backend.domain.home.dto;

import com.movieglass.backend.domain.movie.entity.Movie;
import com.movieglass.backend.domain.curation.entity.Curation;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class HomeResponseDto {
    private final List<Movie> top10Movies;
    private final List<Curation> weatherCurations;
    private final List<Curation> otherCurations;

    public static HomeResponseDto of(List<Movie> top10Movies, List<Curation> weatherCurations, List<Curation> otherCurations) {
        return HomeResponseDto.builder()
                .top10Movies(top10Movies)
                .weatherCurations(weatherCurations)
                .otherCurations(otherCurations)
                .build();
    }
}
