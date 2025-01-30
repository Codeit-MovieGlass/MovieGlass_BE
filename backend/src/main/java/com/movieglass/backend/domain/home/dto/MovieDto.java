package com.movieglass.backend.domain.home.dto;

import com.movieglass.backend.domain.movie.entity.Movie;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MovieDto {
    private final Long id;
    private final String kmdbId;
    private final String tmdbId;
    private final String movieName;
    private final Integer productionYear;
    private final String productionGenre;
    private final String productionCountry;
    private final String productionImage;
    private final String horizontalImage;
    private final String trailerUrl;

    public static MovieDto from(Movie movie) {
        return MovieDto.builder()
                .id(movie.getId())
                .kmdbId(movie.getKmdbId())
                .tmdbId(movie.getTmdbId())
                .movieName(movie.getMovieName())
                .productionYear(movie.getProductionYear())
                .productionGenre(movie.getProductionGenre())
                .productionCountry(movie.getProductionCountry())
                .productionImage(movie.getProductionImage())
                .horizontalImage(movie.getHorizontalImage())
                .trailerUrl(movie.getTrailerUrl())
                .build();
    }
}
