package com.movieglass.backend.domain.home.dto.response;

import com.movieglass.backend.domain.home.dto.CurationMoviesDto;
import com.movieglass.backend.domain.home.dto.MovieDto;
import com.movieglass.backend.domain.movie.entity.Movie;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class HomeResponseDto {
    private final List<MovieDto> top10Movies;
    private final List<CurationMoviesDto> weatherCurations;
    private final List<CurationMoviesDto> otherCurations;

    public static HomeResponseDto of(List<Movie> top10Movies, List<CurationMoviesDto> weatherCurations, List<CurationMoviesDto> otherCurations) {
        return HomeResponseDto.builder()
                .top10Movies(top10Movies.stream().map(MovieDto::from).toList())
                .weatherCurations(weatherCurations)
                .otherCurations(otherCurations)
                .build();
    }
}
