package com.movieglass.backend.domain.movie.converter;

import com.movieglass.backend.domain.movie.dto.MovieDetailResponseDTO;
import com.movieglass.backend.domain.movie.entity.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieConverter {

    public MovieDetailResponseDTO toDetailResponseDTO(Movie movie) {
        return new MovieDetailResponseDTO(
                movie.getId(),
                movie.getMovieName(),
                String.valueOf(movie.getProductionYear()),
                movie.getProductionType(),
                movie.getProductionLength(),
                movie.getProductionGenre(),
                movie.getProductionCountry(),
                movie.getProductionPlot(),
                movie.getProductionImage(),
                movie.getHorizontalImage(),
                movie.getTrailerUrl() // 새 필드 추가
        );
    }
}
